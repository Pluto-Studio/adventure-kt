package plutoproject.adventurekt.util

import plutoproject.adventurekt.text.ComponentKt
import plutoproject.adventurekt.text.cleanBuild
import net.kyori.adventure.text.Component

class Holder<T>(
    val container: ComponentKt,
    var value: T?
) {

    internal var cleanBuilt: Boolean = false

}

fun <T> Holder<T>.cleanBuild(): Component {
    this.cleanBuilt = true
    return this.container.cleanBuild()
}