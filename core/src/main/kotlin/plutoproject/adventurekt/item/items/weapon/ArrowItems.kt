package plutoproject.adventurekt.item.items.weapon

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.Item
import plutoproject.adventurekt.item.Items

val Items.Arrow: Item
    get() = Item(Key.key("minecraft:arrow"))
val Items.SpectralArrow: Item
    get() = Item(Key.key("minecraft:spectral_arrow"))
val Items.TippedArrow: Item
    get() = Item(Key.key("minecraft:tipped_arrow"))