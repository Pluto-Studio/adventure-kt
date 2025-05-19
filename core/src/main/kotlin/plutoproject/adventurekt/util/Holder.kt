package plutoproject.adventurekt.util

import plutoproject.adventurekt.text.ComponentKt
import plutoproject.adventurekt.text.cleanBuild
import net.kyori.adventure.text.Component

class Holder<T>(
    val container: ComponentKt,
    var value: T?
) {

    internal var cleanBuilt: Component? = null

}

fun <T> Holder<T>.cleanBuild(): Component {
    if (this.cleanBuilt == null) {
        this.cleanBuilt = this.container.cleanBuild()
    }
    return this.cleanBuilt!!
}