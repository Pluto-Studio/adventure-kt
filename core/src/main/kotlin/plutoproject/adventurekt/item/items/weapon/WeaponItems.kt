package plutoproject.adventurekt.item.items.weapon

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.Item
import plutoproject.adventurekt.item.Items

val Items.Bow: Item
    get() = Item(Key.key("minecraft:bow"))
val Items.Crossbow: Item
    get() = Item(Key.key("minecraft:crossbow"))
val Items.Mace: Item
    get() = Item(Key.key("minecraft:mace"))
val Items.Shield: Item
    get() = Item(Key.key("minecraft:shield"))
val Items.Trident: Item
    get() = Item(Key.key("minecraft:trident"))