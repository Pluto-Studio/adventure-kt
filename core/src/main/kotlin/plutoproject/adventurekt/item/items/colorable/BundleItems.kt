package plutoproject.adventurekt.item.items.colorable

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.Item
import plutoproject.adventurekt.item.Items
import plutoproject.adventurekt.item.OriginableColorableItem

val Items.Bundle: OriginableColorableItem
    get() = OriginableColorableItem(
        Key.key("minecraft:bundle"),
        WhiteBundle,
        OrangeBundle,
        MagentaBundle,
        LightBlueBundle,
        YellowBundle,
        LimeBundle,
        PinkBundle,
        GrayBundle,
        LightGrayBundle,
        CyanBundle,
        PurpleBundle,
        BlueBundle,
        BrownBundle,
        GreenBundle,
        RedBundle,
        BlackBundle
    )

val Items.BlackBundle: Item
    get() = Item(Key.key("minecraft:black_bundle"))
val Items.BlueBundle: Item
    get() = Item(Key.key("minecraft:blue_bundle"))
val Items.BrownBundle: Item
    get() = Item(Key.key("minecraft:brown_bundle"))
val Items.CyanBundle: Item
    get() = Item(Key.key("minecraft:cyan_bundle"))
val Items.GrayBundle: Item
    get() = Item(Key.key("minecraft:gray_bundle"))
val Items.GreenBundle: Item
    get() = Item(Key.key("minecraft:green_bundle"))
val Items.LightBlueBundle: Item
    get() = Item(Key.key("minecraft:light_blue_bundle"))
val Items.LightGrayBundle: Item
    get() = Item(Key.key("minecraft:light_gray_bundle"))
val Items.LimeBundle: Item
    get() = Item(Key.key("minecraft:lime_bundle"))
val Items.MagentaBundle: Item
    get() = Item(Key.key("minecraft:magenta_bundle"))
val Items.OrangeBundle: Item
    get() = Item(Key.key("minecraft:orange_bundle"))
val Items.PinkBundle: Item
    get() = Item(Key.key("minecraft:pink_bundle"))
val Items.PurpleBundle: Item
    get() = Item(Key.key("minecraft:purple_bundle"))
val Items.RedBundle: Item
    get() = Item(Key.key("minecraft:red_bundle"))
val Items.WhiteBundle: Item
    get() = Item(Key.key("minecraft:white_bundle"))
val Items.YellowBundle: Item
    get() = Item(Key.key("minecraft:yellow_bundle"))