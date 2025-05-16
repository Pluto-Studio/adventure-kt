package plutoproject.adventurekt.extension

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextReplacementConfig
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.serializer.ansi.ANSIComponentSerializer
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer

fun Component.gson(): String {
    return GsonComponentSerializer.gson().serialize(this)
}

fun Component.legacy(legacyChar: Char): String {
    return LegacyComponentSerializer.legacy(legacyChar).serialize(this)
}

fun Component.legacySection(): String {
    return LegacyComponentSerializer.legacySection().serialize(this)
}

fun Component.legacyAmpersand(): String {
    return LegacyComponentSerializer.legacyAmpersand().serialize(this)
}

fun Component.plain(): String {
    return PlainTextComponentSerializer.plainText().serialize(this)
}

fun Component.ansi(): String {
    return ANSIComponentSerializer.ansi().serialize(this)
}

fun Component.replace(string: String, text: String, literal: Boolean = false): Component {
    return this.replace(string, Component.text(text), literal)
}

fun Component.replace(string: String, component: Component, literal: Boolean = false): Component {
    val replaceConfig = TextReplacementConfig.builder()
        .apply {
            if (literal)
                this.matchLiteral(string)
            else
                this.match(string)
        }
        .replacement(component)
        .build()

    return this.replaceText(replaceConfig)
}

fun Component.replace(string: String, literal: Boolean = false, replacement: (Component) -> Component): Component {
    val replaceConfig = TextReplacementConfig.builder()
        .apply {
            if (literal)
                this.matchLiteral(string)
            else
                this.match(string)
        }
        .replacement { builder ->
            return@replacement replacement(builder.build())
        }
        .build()

    return this.replaceText(replaceConfig)
}

fun Component.replaceColor(targetColor: TextColor, newColor: TextColor): Component {
    val updatedComponent = if (this.color() == targetColor) {
        this.color(newColor)
    } else {
        this
    }

    return updatedComponent.children().fold(updatedComponent.children(emptyList())) { component, child ->
        component.append(child.replaceColor(targetColor, newColor))
    }
}