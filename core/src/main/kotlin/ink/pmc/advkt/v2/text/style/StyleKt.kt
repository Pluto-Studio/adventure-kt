package ink.pmc.advkt.v2.text.style

import ink.pmc.advkt.v2.text.ComponentKt
import net.kyori.adventure.text.Component

interface Style

interface WithStyle {

    fun with(holder: ComponentKt, original: Component): Component

}

interface WithoutStyle {

    fun without(holder: ComponentKt, original: Component): Component

}

interface BothStyle : WithStyle, WithoutStyle