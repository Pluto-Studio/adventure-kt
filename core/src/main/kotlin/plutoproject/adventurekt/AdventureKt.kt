package plutoproject.adventurekt

import plutoproject.adventurekt.text.ComponentKt
import plutoproject.adventurekt.text.TextComponentKt
import plutoproject.adventurekt.text.build
import net.kyori.adventure.text.Component

fun component(content: ComponentKt.() -> Unit): Component {
    return TextComponentKt(Component.empty()).apply(content).build()
}