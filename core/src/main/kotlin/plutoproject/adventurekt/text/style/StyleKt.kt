package plutoproject.adventurekt.text.style

import plutoproject.adventurekt.text.ComponentKt
import net.kyori.adventure.text.Component

interface Style

interface WithStyle {

    fun with(holder: ComponentKt, original: Component): Component

}

interface WithoutStyle {

    fun without(holder: ComponentKt, original: Component): Component

}

interface BothStyle : WithStyle, WithoutStyle