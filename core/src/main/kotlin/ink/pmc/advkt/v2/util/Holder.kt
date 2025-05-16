package ink.pmc.advkt.v2.util

import ink.pmc.advkt.v2.text.ComponentKt
import ink.pmc.advkt.v2.text.cleanBuild
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