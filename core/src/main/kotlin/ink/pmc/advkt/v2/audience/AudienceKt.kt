package ink.pmc.advkt.v2.audience

import ink.pmc.advkt.v2.component
import ink.pmc.advkt.v2.text.ComponentKt
import net.kyori.adventure.audience.Audience

fun Audience.send(content: ComponentKt.() -> Unit) {
    this.sendMessage(component(content))
}