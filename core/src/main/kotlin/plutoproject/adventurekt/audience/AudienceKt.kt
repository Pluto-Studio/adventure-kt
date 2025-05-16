package plutoproject.adventurekt.audience

import plutoproject.adventurekt.component
import plutoproject.adventurekt.text.ComponentKt
import net.kyori.adventure.audience.Audience

fun Audience.send(content: ComponentKt.() -> Unit) {
    this.sendMessage(component(content))
}