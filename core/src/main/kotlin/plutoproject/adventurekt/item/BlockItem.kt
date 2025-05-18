package plutoproject.adventurekt.item

import net.kyori.adventure.key.Key

open class BlockItem(
    internal val internalItemId: Key?,
    val blockId: Key,
) : Item(internalItemId ?: Items.Air.id) {

    override val id: Key
        get() = this.internalItemId ?: throw RuntimeException("This block has no item")

    val itemId: Key
        get() = id

}