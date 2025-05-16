package ink.pmc.advkt.v2_old.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

interface ComponentContainer {

    val miniMessageInstance: MiniMessage

    // attributes
    fun behaviour(builder: ComponentBehaviourBuilder.() -> Unit)

    fun replacements(builder: ComponentReplacements.() -> Unit)

    fun miniMessage(builder: MiniMessageBuilder.() -> Unit)

    // content
    fun raw(component: Component): ComponentKt

    fun text(text: String): ComponentKt {
        return raw(Component.text(text))
    }

    fun text(text: Char): ComponentKt {
        return raw(Component.text(text))
    }

    fun text(text: Boolean): ComponentKt {
        return raw(Component.text(text))
    }

    fun text(text: Int): ComponentKt {
        return raw(Component.text(text))
    }

    fun text(text: Long): ComponentKt {
        return raw(Component.text(text))
    }

    fun text(text: Float): ComponentKt {
        return raw(Component.text(text))
    }

    fun text(text: Double): ComponentKt {
        return raw(Component.text(text))
    }

    fun translatable(text: String): ComponentKt {
        return raw(Component.translatable(text))
    }

    fun keybind(text: String): ComponentKt {
        return raw(Component.keybind(text))
    }

    fun component(builder: TextContainer.() -> Unit){
        this.raw(TextContainer().apply(builder).build())
    }

    fun miniMessage(text: String): ComponentKt

    fun newline()

    fun space()

    fun empty()

    // functions
    fun isEmpty(): Boolean

}