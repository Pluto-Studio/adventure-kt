package ink.pmc.advkt.v2.extension

import net.kyori.adventure.text.Component
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