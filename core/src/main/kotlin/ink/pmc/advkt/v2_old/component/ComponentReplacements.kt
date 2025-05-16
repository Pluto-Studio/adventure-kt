package ink.pmc.advkt.v2_old.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextReplacementConfig

class ComponentReplacements(
    private val parent: ComponentReplacements? = null
) {

    private var overridden = false
    private val replacements = mutableListOf<TextReplacementConfig>()

    fun replacement(builder: TextReplacementConfig.Builder.() -> Unit) {
        this.replacements.add(TextReplacementConfig.builder().apply(builder).build())
    }

    fun override() {
        this.overridden = true
    }

    fun apply(component: Component): Component {
        var replacer = this
        var variable = component
        do {

            for (replacementConfig in replacer.replacements) {
                variable = variable.replaceText(replacementConfig)
            }
            replacer = replacer.parent ?: ComponentReplacements()
        } while (replacer.parent != null && !replacer.overridden)
        return variable
    }

}

fun TextReplacementConfig.Builder.replace(builder: TextContainer.(original: Component) -> Unit) {
    this.replacement { builder ->
        return@replacement TextContainer().apply {
            this.builder(builder.build())
        }.build()
    }
}