package plutoproject.adventurekt.item.blocks.transport

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.Items

val Items.ActivatorRail: BlockItem
    get() = BlockItem(Key.key("minecraft:activator_rail"), Key.key("minecraft:activator_rail"))
val Items.DetectorRail: BlockItem
    get() = BlockItem(Key.key("minecraft:detector_rail"), Key.key("minecraft:detector_rail"))
val Items.PoweredRail: BlockItem
    get() = BlockItem(Key.key("minecraft:powered_rail"), Key.key("minecraft:powered_rail"))
val Items.Rail: BlockItem
    get() = BlockItem(Key.key("minecraft:rail"), Key.key("minecraft:rail"))
