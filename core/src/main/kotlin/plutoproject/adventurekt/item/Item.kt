package plutoproject.adventurekt.item

import net.kyori.adventure.key.Key

open class Item(
    open val id: Key
) {

    override fun equals(other: Any?): Boolean {
        if (other == null)
            return false
        if (this === other)
            return true
        if (other !is Item)
            return false
        return this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}

object Items {

    val Air: Item = Item(Key.key("minecraft:air"))

}