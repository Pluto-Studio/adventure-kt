package plutoproject.adventurekt.text

import plutoproject.adventurekt.text.style.ColorKt
import plutoproject.adventurekt.text.style.DecorationStyle
import plutoproject.adventurekt.text.style.GradientColorKt
import plutoproject.adventurekt.text.style.GradientColorWithStyle
import plutoproject.adventurekt.text.style.WithStyle
import plutoproject.adventurekt.text.style.WithoutStyle
import plutoproject.adventurekt.text.style.toShadowColor
import plutoproject.adventurekt.text.style.toTextColor
import plutoproject.adventurekt.util.Holder
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.JoinConfiguration
import net.kyori.adventure.text.format.ShadowColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.minimessage.MiniMessage
import plutoproject.adventurekt.text.style.BothStyle

interface ComponentKt

interface WithTag : ComponentKt
interface WithoutTag : ComponentKt

fun ComponentKt.text(value: () -> Any): ComponentKt {
    return text(value().toString())
}

fun ComponentKt.translatable(value: () -> String): ComponentKt {
    return translatable(value())
}

fun ComponentKt.keybind(value: () -> String): ComponentKt {
    return keybind(value())
}

fun ComponentKt.raw(value: () -> Component): ComponentKt {
    return raw(value())
}

fun ComponentKt.text(value: String): ComponentKt {
    val component = TextComponentKt(Component.text(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.text(value: Char): ComponentKt {
    val component = TextComponentKt(Component.text(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.text(value: Int): ComponentKt {
    val component = TextComponentKt(Component.text(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.text(value: Long): ComponentKt {
    val component = TextComponentKt(Component.text(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.text(value: Float): ComponentKt {
    val component = TextComponentKt(Component.text(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.text(value: Double): ComponentKt {
    val component = TextComponentKt(Component.text(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.text(value: Boolean): ComponentKt {
    val component = TextComponentKt(Component.text(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.translatable(value: String): ComponentKt {
    val component = TextComponentKt(Component.translatable(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.keybind(value: String): ComponentKt {
    val component = TextComponentKt(Component.keybind(value))
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.raw(value: Component): ComponentKt {
    val component = TextComponentKt(value)
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.empty() {
    val holder = Holder<Component>(this, Component.empty())
    ((this as TextComponentKt).actions as ComponentActionsImpl).emptyAction(holder)
    if (holder.value != null && !holder.cleanBuilt) {
        this.children.add(TextComponentKt(holder.value!!))
    }
}

fun ComponentKt.space() {
    val holder = Holder<Component>(this, Component.space())
    ((this as TextComponentKt).actions as ComponentActionsImpl).spaceAction(holder)
    if (holder.value != null && !holder.cleanBuilt) {
        this.children.add(TextComponentKt(holder.value!!))
    }
}

fun ComponentKt.newline() {
    val holder = Holder<Component>(this, Component.newline())
    ((this as TextComponentKt).actions as ComponentActionsImpl).newlineAction(holder)
    if (holder.value != null && !holder.cleanBuilt) {
        this.children.add(TextComponentKt(holder.value!!))
    }
}

fun ComponentKt.mini(text: String, context: MiniMessageContext.() -> Unit = {}): ComponentKt {
    val finalContext = MiniMessageContextKt().apply(context)
    val miniMessage = finalContext.miniMessage ?: (this as TextComponentKt).miniMessage
    val pointered = finalContext.pointered
    val component = if (pointered == null) {
        TextComponentKt(miniMessage.deserialize(text, *finalContext.tagResolvers.toTypedArray()))
    } else {
        TextComponentKt(miniMessage.deserialize(text, pointered, *finalContext.tagResolvers.toTypedArray()))
    }
    (this as TextComponentKt).children.add(component)
    return component
}

fun ComponentKt.miniMessage(builder: MiniMessageBuilder.() -> Unit) {
    (this as TextComponentKt).miniMessage = MiniMessageBuilderKt().apply(builder).build()
}

fun ComponentKt.replacements(builder: ComponentReplacements.() -> Unit) {
    if ((this as TextComponentKt).replacements != null) {
        val parent = this.replacements!!
        this.replacements = ComponentReplacements(parent).apply(builder)
    } else {
        this.replacements = ComponentReplacements().apply(builder)
    }
}

fun ComponentKt.joinConfiguration(builder: JoinConfiguration.Builder.() -> Unit) {
    (this as TextComponentKt).joinConfiguration = JoinConfiguration.builder().apply(builder).build()
}

///////////////////////////////////////////////////////////////////////////////////////////
// STYLE 1 START
///////////////////////////////////////////////////////////////////////////////////////////

infix fun ComponentKt.provide(style: BothStyle): ComponentKt {
    (this as TextComponentKt).original = style.with(this, this.original)
    return this
}

infix fun ComponentKt.with(style: WithStyle): WithTag {
    (this as TextComponentKt).original = style.with(this, this.original)
    return this as WithTag
}

// for better visual only
infix fun WithTag.and(style: WithStyle): WithTag {
    (this as TextComponentKt).original = style.with(this, this.original)
    return this
}

// color only
// 6~7 for text color
// 8~9 for shadow color
infix fun ComponentKt.with(hex: String): WithTag {
    return (this as WithTag).and(hex)
}

// 6~7 for text color
// 8~9 for shadow color
// for better visual only
infix fun WithTag.and(hex: String): WithTag {
    (this as TextComponentKt).original = if (hex.startsWith("#")) {
        if (hex.length == 9) {
            val color = ShadowColor.fromHexString(hex) ?: throw IllegalArgumentException("Invalid hex string: $hex")
            this.original.shadowColor(color)
        } else if (hex.length == 7) {
            val color = TextColor.fromHexString(hex) ?: throw IllegalArgumentException("Invalid hex string: $hex")
            this.original.color(color)
        } else {
            throw IllegalArgumentException("Invalid hex string: $hex")
        }
    } else {
        if (hex.length == 8) {
            val color = ShadowColor.fromHexString("#$hex") ?: throw IllegalArgumentException("Invalid hex string: #$hex")
            this.original.shadowColor(color)
        } else if (hex.length == 6) {
            val color = TextColor.fromHexString("#$hex") ?: throw IllegalArgumentException("Invalid hex string: #$hex")
            this.original.color(color)
        } else {
            throw IllegalArgumentException("Invalid hex string: $hex")
        }
    }
    return this
}

infix fun ComponentKt.without(style: WithoutStyle): WithoutTag {
    (this as TextComponentKt).original = style.without(this, this.original)
    return this as WithoutTag
}

infix fun WithoutTag.and(style: WithoutStyle): WithoutTag {
    (this as TextComponentKt).original = style.without(this, this.original)
    return this
}

///////////////////////////////////////////////////////////////////////////////////////////
// STYLE 1 END
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
// STYLE 2 START
///////////////////////////////////////////////////////////////////////////////////////////

infix fun ComponentKt.color(color: String?): ComponentKt {
    if (color == null) {
        (this as TextComponentKt).original = this.original.color(null)
        return this
    }
    val color = if (color.startsWith("#")) {
        TextColor.fromHexString(color)
    } else {
        TextColor.fromHexString("#$color")
    }
    (this as TextComponentKt).original = this.original.color(color)
    return this
}

infix fun ComponentKt.color(color: ColorKt): ComponentKt {
    (this as TextComponentKt).original = this.original.color(color.toTextColor())
    return this
}

infix fun ComponentKt.color(color: GradientColorKt): ComponentKt {
    (this as TextComponentKt).original = GradientColorWithStyle(color.colors.map { it.toTextColor() }).with(this, this.original)
    return this
}

infix fun ComponentKt.shadow(color: String?): ComponentKt {
    if (color == null) {
        (this as TextComponentKt).original = this.original.shadowColor(null)
        return this
    }
    val color = if (color.startsWith("#")) {
        ShadowColor.fromHexString(color)
    } else {
        ShadowColor.fromHexString("#$color")
    }
    (this as TextComponentKt).original = this.original.shadowColor(color)
    return this
}

infix fun ComponentKt.shadow(color: ColorKt): ComponentKt {
    (this as TextComponentKt).original = this.original.shadowColor(color.toShadowColor())
    return this
}

infix fun ComponentKt.deco(decoration: DecorationStyle): ComponentKt {
    (this as TextComponentKt).original = decoration.with(this, this.original)
    return this
}

infix fun ComponentKt.undeco(decoration: DecorationStyle): ComponentKt {
    (this as TextComponentKt).original = decoration.with(this, this.original)
    return this
}

///////////////////////////////////////////////////////////////////////////////////////////
// STYLE 2 END
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
// STYLE 3 START
///////////////////////////////////////////////////////////////////////////////////////////

fun ComponentKt.decorate(decoration: DecorationStyle, flag: Boolean = true): ComponentKt {
    if (flag)
        (this as TextComponentKt).original = decoration.with(this, this.original)
    else
        (this as TextComponentKt).original = decoration.without(this, this.original)
    return this
}

///////////////////////////////////////////////////////////////////////////////////////////
// STYLE 3 END
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
// PRIVATE
///////////////////////////////////////////////////////////////////////////////////////////

internal class TextComponentKt(
    internal var original: Component,
    internal var actions: ComponentActions = ComponentActionsImpl(),
    internal var miniMessage: MiniMessage = MiniMessage.miniMessage(),
    internal var replacements: ComponentReplacements? = null,
    internal var joinConfiguration: JoinConfiguration? = null,
    internal val children: MutableList<ComponentKt> = mutableListOf() // only root component uses
) : ComponentKt, WithTag, WithoutTag

internal fun ComponentKt.build(): Component {
    if ((this as TextComponentKt).joinConfiguration == null) {
        val builder = Component.empty().toBuilder()
        builder.append(this.original)
        for (child in this.children) {
            builder.append((child as TextComponentKt).build())
        }
        return applyReplacement(builder.build())
    } else {
        return Component.join(this.joinConfiguration!!, this.children.map { applyReplacement((it as TextComponentKt).build()) })
    }
}

internal fun ComponentKt.cleanBuild(): Component {
    if ((this as TextComponentKt).joinConfiguration == null) {
        val builder = Component.empty().toBuilder()
        builder.append(this.original)
        for (child in this.children) {
            builder.append((child as TextComponentKt).build())
        }
        this.original = Component.empty()
        this.children.clear()
        return applyReplacement(builder.build())
    } else {
        val result = Component.join(this.joinConfiguration!!, this.children.map { applyReplacement((it as TextComponentKt).build()) })
        this.original = Component.empty()
        this.children.clear()
        return applyReplacement(result)
    }
}

internal fun TextComponentKt.applyReplacement(component: Component): Component {
    return if (this.replacements != null) {
        this.replacements!!.apply(component)
    } else {
        component
    }
}