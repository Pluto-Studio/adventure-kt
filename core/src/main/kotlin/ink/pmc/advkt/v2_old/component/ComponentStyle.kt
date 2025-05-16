package ink.pmc.advkt.v2_old.component

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickCallback
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import java.net.URL

enum class ApplyType {

    WITH, WITHOUT

}

interface ComponentStyle {

    fun apply(container: ComponentContainer, component: Component, type: ApplyType): Component

}

private class TextDecorationStyle(
    private val decoration: TextDecoration
) : ComponentStyle {

    override fun apply(container: ComponentContainer, component: Component, type: ApplyType): Component {
        return component.decoration(this.decoration, type.toState())
    }

    private fun ApplyType.toState(): TextDecoration.State {
        return when (this) {
            ApplyType.WITH -> TextDecoration.State.TRUE
            ApplyType.WITHOUT -> TextDecoration.State.FALSE
        }
    }

}

fun obfuscate(): ComponentStyle {
    return TextDecorationStyle(
        TextDecoration.OBFUSCATED
    )
}

fun bold(): ComponentStyle {
    return TextDecorationStyle(
        TextDecoration.BOLD
    )
}

fun strikethrough(): ComponentStyle {
    return TextDecorationStyle(
        TextDecoration.STRIKETHROUGH
    )
}

fun underlined(): ComponentStyle {
    return TextDecorationStyle(
        TextDecoration.UNDERLINED
    )
}

fun italic(): ComponentStyle {
    return TextDecorationStyle(
        TextDecoration.ITALIC
    )
}

private class TextColorStyle(
    private val color: TextColor
) : ComponentStyle {

    override fun apply(container: ComponentContainer, component: Component, type: ApplyType): Component {
        return component.color(if (type == ApplyType.WITH) color else null)
    }

}

private class GradientColorStyle(
    private val from: TextColor,
    private val to: TextColor,
    private val more: List<TextColor>
) : ComponentStyle {

    override fun apply(container: ComponentContainer, component: Component, type: ApplyType): Component {
        return if (type == ApplyType.WITH)
            container.miniMessageInstance.deserialize(
                "<gradient${this.buildString()}>${container.miniMessageInstance.serialize(component)}</gradient>"
            )
        else
            component.color(null)
    }

    fun buildString(): String {
        val builder = StringBuilder()
        builder.append(":")
            .append(this.from.asHexString())
            .append(":")
            .append(this.to.asHexString())
        for (color in this.more) {
            builder.append(":")
                .append(color.asHexString())
        }
        return builder.toString()
    }

}

fun color(): ComponentStyle { // this method is used for "without" method
    return white()
}

fun color(textColor: TextColor): ComponentStyle {
    return TextColorStyle(textColor)
}

fun rgb(r: Int, g: Int, b: Int): ComponentStyle {
    return TextColorStyle(TextColor.color(r, g, b))
}

fun rgb(rgb: Int): ComponentStyle {
    return TextColorStyle(TextColor.color(rgb))
}

fun hex(hex: String): ComponentStyle {
    if (!hex.startsWith("#"))
        return TextColorStyle(TextColor.fromHexString("#$hex")!!)
    return TextColorStyle(TextColor.fromHexString(hex)!!)
}

fun gradient(from: TextColor, to: TextColor, vararg more: TextColor): ComponentStyle {
    return GradientColorStyle(from, to, more.toList())
}

fun black(): ComponentStyle {
    return TextColorStyle(NamedTextColor.BLACK)
}

fun darkBlue(): ComponentStyle {
    return TextColorStyle(NamedTextColor.DARK_BLUE)
}

fun darkGreen(): ComponentStyle {
    return TextColorStyle(NamedTextColor.DARK_GREEN)
}

fun darkAqua(): ComponentStyle {
    return TextColorStyle(NamedTextColor.DARK_AQUA)
}

fun darkRed(): ComponentStyle {
    return TextColorStyle(NamedTextColor.DARK_RED)
}

fun darkPurple(): ComponentStyle {
    return TextColorStyle(NamedTextColor.DARK_PURPLE)
}

fun gold(): ComponentStyle {
    return TextColorStyle(NamedTextColor.GOLD)
}

fun gray(): ComponentStyle {
    return TextColorStyle(NamedTextColor.GRAY)
}

fun darkGray(): ComponentStyle {
    return TextColorStyle(NamedTextColor.DARK_GRAY)
}

fun blue(): ComponentStyle {
    return TextColorStyle(NamedTextColor.BLUE)
}

fun green(): ComponentStyle {
    return TextColorStyle(NamedTextColor.GREEN)
}

fun aqua(): ComponentStyle {
    return TextColorStyle(NamedTextColor.AQUA)
}

fun red(): ComponentStyle {
    return TextColorStyle(NamedTextColor.RED)
}

fun lightPurple(): ComponentStyle {
    return TextColorStyle(NamedTextColor.LIGHT_PURPLE)
}

fun yellow(): ComponentStyle {
    return TextColorStyle(NamedTextColor.YELLOW)
}

fun white(): ComponentStyle {
    return TextColorStyle(NamedTextColor.WHITE)
}

fun TextColor.kt(): ComponentStyle {
    return TextColorStyle(this)
}

private class ClickEventStyle(
    private val clickEvent: ClickEvent?
): ComponentStyle {
    
    override fun apply(
        container: ComponentContainer,
        component: Component,
        type: ApplyType
    ): Component {
        return if (type == ApplyType.WITH) {
            component.clickEvent(clickEvent)
        } else {
            component.clickEvent(null)
        }
    }

}


fun clickEvent(): ComponentStyle {
    return ClickEventStyle(null)
}

fun openUrl(url: String): ComponentStyle {
    return ClickEventStyle(ClickEvent.openUrl(url))
}

fun openUrl(url: URL): ComponentStyle {
    return ClickEventStyle(ClickEvent.openUrl(url))
}

fun openFile(file: String): ComponentStyle {
    return ClickEventStyle(ClickEvent.openFile(file))
}

fun runCommand(command: String): ComponentStyle {
    return ClickEventStyle(ClickEvent.runCommand(command))
}

fun suggestCommand(command: String): ComponentStyle {
    return ClickEventStyle(ClickEvent.suggestCommand(command))
}

fun changePage(page: String): ComponentStyle {
    return ClickEventStyle(ClickEvent.changePage(page))
}

fun changePage(page: Int): ComponentStyle {
    return ClickEventStyle(ClickEvent.changePage(page))
}

fun copyToClipboard(text: String): ComponentStyle {
    return ClickEventStyle(ClickEvent.copyToClipboard(text))
}

fun callback(function: (Audience) -> Unit): ComponentStyle {
    return ClickEventStyle(ClickEvent.callback(function))
}

fun callback(options: ClickCallback.Options, function: (Audience) -> Unit): ComponentStyle {
    return ClickEventStyle(ClickEvent.callback(function, options))
}

fun ClickEvent.kt(): ComponentStyle {
    return ClickEventStyle(this)
}

private class HoverEventStyle(
    private val hoverEvent: HoverEvent<*>?
): ComponentStyle {

    override fun apply(
        container: ComponentContainer,
        component: Component,
        type: ApplyType
    ): Component {
        return if (type == ApplyType.WITH) {
            component.hoverEvent(hoverEvent)
        } else {
            component.hoverEvent(null)
        }
    }

}

fun hoverEvent(): ComponentStyle {
    return HoverEventStyle(null)
}

fun showText(text: TextContainer.() -> Unit): ComponentStyle {
    return HoverEventStyle(HoverEvent.showText(TextContainer().apply(text).build()))
}

fun HoverEvent<*>.kt(): ComponentStyle {
    return HoverEventStyle(this)
}
private class InsertionStyle(
    private val value: String
): ComponentStyle {

    override fun apply(
        container: ComponentContainer,
        component: Component,
        type: ApplyType
    ): Component {
        return if (type == ApplyType.WITH)
            component.insertion(this.value)
        else
            component.insertion(null)
    }

}

fun insertion(): ComponentStyle {
    return InsertionStyle("")
}

fun insertion(value: String): ComponentStyle {
    return InsertionStyle(value)
}