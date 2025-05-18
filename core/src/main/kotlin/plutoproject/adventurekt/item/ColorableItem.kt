package plutoproject.adventurekt.item

import net.kyori.adventure.key.Key

open class ColorableItem(
    val white: Item,
    val orange: Item,
    val magenta: Item,
    val lightBlue: Item,
    val yellow: Item,
    val lime: Item,
    val pink: Item,
    val gray: Item,
    val lightGray: Item,
    val cyan: Item,
    val purple: Item,
    val blue: Item,
    val brown: Item,
    val green: Item,
    val red: Item,
    val black: Item
)

open class OriginableColorableItem(
    id: Key,
    val white: Item,
    val orange: Item,
    val magenta: Item,
    val lightBlue: Item,
    val yellow: Item,
    val lime: Item,
    val pink: Item,
    val gray: Item,
    val lightGray: Item,
    val cyan: Item,
    val purple: Item,
    val blue: Item,
    val brown: Item,
    val green: Item,
    val red: Item,
    val black: Item
): Item(id)

open class ColorableBlockItem(
    val white: BlockItem,
    val orange: BlockItem,
    val magenta: BlockItem,
    val lightBlue: BlockItem,
    val yellow: BlockItem,
    val lime: BlockItem,
    val pink: BlockItem,
    val gray: BlockItem,
    val lightGray: BlockItem,
    val cyan: BlockItem,
    val purple: BlockItem,
    val blue: BlockItem,
    val brown: BlockItem,
    val green: BlockItem,
    val red: BlockItem,
    val black: BlockItem
)

open class OriginableColorableBlockItem(
    private val original: BlockItem,
    val white: BlockItem,
    val orange: BlockItem,
    val magenta: BlockItem,
    val lightBlue: BlockItem,
    val yellow: BlockItem,
    val lime: BlockItem,
    val pink: BlockItem,
    val gray: BlockItem,
    val lightGray: BlockItem,
    val cyan: BlockItem,
    val purple: BlockItem,
    val blue: BlockItem,
    val brown: BlockItem,
    val green: BlockItem,
    val red: BlockItem,
    val black: BlockItem
): BlockItem(
    original.internalItemId,
    original.blockId
)