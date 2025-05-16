package ink.pmc.advkt.v2.text.style

import ink.pmc.advkt.v2.text.ComponentKt
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration

val obfuscated: DecorationStyle = DecorationStyle(TextDecoration.OBFUSCATED)

val bold: DecorationStyle = DecorationStyle(TextDecoration.BOLD)

val strikethrough: DecorationStyle = DecorationStyle(TextDecoration.STRIKETHROUGH)

val underlined: DecorationStyle = DecorationStyle(TextDecoration.UNDERLINED)

val italic: DecorationStyle = DecorationStyle(TextDecoration.ITALIC)

class DecorationStyle(val decoration: TextDecoration) : BothStyle {

    override fun with(holder: ComponentKt, original: Component): Component {
        return original.decoration(this.decoration, true)
    }

    override fun without(holder: ComponentKt, original: Component): Component {
        return original.decoration(this.decoration, false)
    }

}