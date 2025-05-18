package plutoproject.adventurekt.text.style

import plutoproject.adventurekt.text.ComponentKt
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.ShadowColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.format.Style as KStyle

interface Style

interface WithStyle {

    fun with(holder: ComponentKt, original: Component): Component

}

interface WithoutStyle {

    fun without(holder: ComponentKt, original: Component): Component

}

interface BothStyle : WithStyle, WithoutStyle {

    override fun with(holder: ComponentKt, original: Component): Component {
        return original
    }

    override fun without(holder: ComponentKt, original: Component): Component {
        return original
    }
    fun apply(holder: ComponentKt, original: Component): Component {
        return original
    }

}

class StyleBuilder {

    internal val style: KStyle.Builder = KStyle.style()

    internal fun build(): BothStyle {
        return FullStyle(this.style.build())
    }

}

fun StyleBuilder.textColor(color: WithStyle) {
    if (color is ColorWithStyle) {
        this.style.color(color.color)
    }
}

fun StyleBuilder.textColor(color: ColorKt) {
    this.style.color(color.toTextColor())
}

fun StyleBuilder.textColor(color: TextColor) {
    this.style.color(color)
}

fun StyleBuilder.textColor(hex: String) {
    this.style.color(TextColor.fromHexString(hex))
}

fun StyleBuilder.shadowColor(color: WithStyle) {
    if (color is ShadowWithStyle) {
        this.style.shadowColor(color.color)
    }
}

fun StyleBuilder.shadowColor(color: ColorKt) {
    this.style.shadowColor(color.toShadowColor())
}

fun StyleBuilder.shadowColor(color: ShadowColor) {
    this.style.shadowColor(color)
}

fun StyleBuilder.shadowColor(hex: String) {
    this.style.shadowColor(ShadowColor.fromHexString(hex))
}

fun StyleBuilder.decoration(decoration: WithStyle) {
    if (decoration is DecorationStyle) {
        this.style.decoration(decoration.decoration, true)
    }
}

fun StyleBuilder.decoration(decoration: TextDecoration) {
    this.style.decoration(decoration, true)
}

fun StyleBuilder.undecoration(decoration: WithStyle) {
    if (decoration is DecorationStyle) {
        this.style.decoration(decoration.decoration, false)
    }
}

fun StyleBuilder.undecoration(decoration: TextDecoration) {
    this.style.decoration(decoration, false)
}

fun style(builder: StyleBuilder.() -> Unit): BothStyle {
    return StyleBuilder().apply(builder).build()
}

/////////////////////////////////////////////////////////////////////////////////////
// PRIVATE
/////////////////////////////////////////////////////////////////////////////////////

internal class FullStyle(val style: KStyle): BothStyle {

    override fun apply(holder: ComponentKt, original: Component): Component {
        return original.style(this.style)
    }

}