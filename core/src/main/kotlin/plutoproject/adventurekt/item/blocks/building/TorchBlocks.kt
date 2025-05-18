package plutoproject.adventurekt.item.blocks.building

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.Items

val Items.RedstoneTorch: BlockItem
    get() = BlockItem(Key.key("minecraft:redstone_torch"), Key.key("minecraft:redstone_torch"))
val Items.SoulTorch: BlockItem
    get() = BlockItem(Key.key("minecraft:soul_torch"), Key.key("minecraft:soul_torch"))
val Items.Torch: BlockItem
    get() = BlockItem(Key.key("minecraft:torch"), Key.key("minecraft:torch"))
val Items.WallTorch: BlockItem
    get() = BlockItem(Key.key("minecraft:torch"), Key.key("minecraft:wall_torch"))