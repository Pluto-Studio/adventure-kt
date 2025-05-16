package ink.pmc.advkt.v2_old.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.JoinConfiguration
import net.kyori.adventure.text.TextReplacementConfig
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.ansi.ANSIComponentSerializer
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import net.kyori.ansi.ColorLevel

open class ComponentKt(
    private val original: Component
) {

    private val styles = mutableListOf<Pair<ComponentStyle, ApplyType>>()

    infix fun with(style: ComponentStyle): ComponentKt {
        this.styles.add(style to ApplyType.WITH)
        return this
    }

    infix fun without(style: ComponentStyle): ComponentKt {
        this.styles.add(style to ApplyType.WITHOUT)
        return this
    }

    fun build(container: ComponentContainer): Component {
        var final = original
        for ((style, type) in styles) {
            final = style.apply(container, final, type)
        }
        return final
    }

}

class TextContainer : ComponentContainer {

    // children
    private val children = mutableListOf<ComponentKt>()

    // attributes
    private var behaviour: ComponentBehaviour = DefaultComponentBehaviour
    private var miniMessage: MiniMessage = MiniMessage.miniMessage()
    private var replacements: ComponentReplacements? = null
    private var joinConfiguration: JoinConfiguration? = null

    override val miniMessageInstance: MiniMessage
        get() = this.miniMessage

    override fun behaviour(builder: ComponentBehaviourBuilder.() -> Unit) {
        this.behaviour = ComponentBehaviourBuilder().apply(builder).build()
    }

    override fun replacements(builder: ComponentReplacements.() -> Unit) {
        if (this.replacements != null) {
            this.replacements!!.builder()
        } else {
            this.replacements = ComponentReplacements().apply(builder)
        }
    }

    override fun miniMessage(builder: MiniMessageBuilder.() -> Unit) {
        this.miniMessage = MiniMessageBuilder().apply(builder).build()
    }

    override fun raw(component: Component): ComponentKt {
        return ComponentKt(component).apply {  }
    }

    override fun miniMessage(text: String): ComponentKt {
        return this.raw(this.miniMessage.deserialize(text))
    }

    override fun newline() {
        this.children.add(ComponentKt(this.behaviour.newline(this)))
    }

    override fun space() {
        this.children.add(ComponentKt(this.behaviour.space(this)))
    }

    override fun empty() {
        this.children.add(ComponentKt(this.behaviour.empty(this)))
    }

    override fun isEmpty(): Boolean {
        return this.children.isEmpty()
    }

    fun joinConfiguration(builder: JoinConfiguration.Builder.() -> Unit) {
        this.joinConfiguration = JoinConfiguration.builder().apply(builder).build()
    }

    fun build(): Component {
        if (this.joinConfiguration == null) {
            var root: Component = Component.empty()
            for (component in this.children) {
                root = root.append(component.build(this))
            }
            return applyReplacement(root)
        } else {
            return Component.join(this.joinConfiguration!!, this.children.map { applyReplacement(it.build(this)) })
        }
    }

    private fun applyReplacement(component: Component): Component {
        return if (this.replacements != null) {
            return this.replacements!!.apply(component)
        } else
            component
    }

}

fun component(builder: TextContainer.() -> Unit): Component {
    return TextContainer().apply(builder).build()
}

fun Component.json(): String {
    return GsonComponentSerializer.gson().serialize(this)
}

fun Component.legacy(): String {
    return LegacyComponentSerializer.legacySection().serialize(this)
}

fun Component.plain(): String {
    return PlainTextComponentSerializer.plainText().serialize(this)
}

fun Component.ansi(): String {
    return ANSIComponentSerializer.builder().colorLevel(ColorLevel.TRUE_COLOR).build().serialize(this)
}

// extension for Component

fun Component.replace(string: String, text: String, literal: Boolean = false): Component {
    return this.replace(string, Component.text(text), literal)
}

fun Component.replace(string: String, component: Component, literal: Boolean = false): Component {
    val replaceConfig = TextReplacementConfig.builder()
        .apply {
            if (literal)
                this.matchLiteral(string)
            else
                this.match(string)
        }
        .replacement(component)
        .build()

    return this.replaceText(replaceConfig)
}

fun Component.replace(string: String, literal: Boolean = false, replacement: (Component) -> Component): Component {
    val replaceConfig = TextReplacementConfig.builder()
        .apply {
            if (literal)
                this.matchLiteral(string)
            else
                this.match(string)
        }
        .replacement { builder ->
            return@replacement replacement(builder.build())
        }
        .build()

    return this.replaceText(replaceConfig)
}

fun Component.replaceColor(targetColor: TextColor, newColor: TextColor): Component {
    val updatedComponent = if (this.color() == targetColor) {
        this.color(newColor)
    } else {
        this
    }

    return updatedComponent.children().fold(updatedComponent.children(emptyList())) { component, child ->
        component.append(child.replaceColor(targetColor, newColor))
    }
}