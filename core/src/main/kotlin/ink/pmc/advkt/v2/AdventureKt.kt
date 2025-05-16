package ink.pmc.advkt.v2

import ink.pmc.advkt.v2.text.ComponentKt
import ink.pmc.advkt.v2.text.TextComponentKt
import ink.pmc.advkt.v2.text.build
import net.kyori.adventure.text.Component

fun component(content: ComponentKt.() -> Unit): Component {
    return TextComponentKt(Component.empty()).apply(content).build()
}