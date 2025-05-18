package plutoproject.adventurekt.item.items.colorable

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.ColorableItem
import plutoproject.adventurekt.item.Item
import plutoproject.adventurekt.item.Items

val Items.Dye: ColorableItem
    get() = ColorableItem(
        WhiteDye,
        OrangeDye,
        MagentaDye,
        LightBlueDye,
        YellowDye,
        LimeDye,
        PinkDye,
        GrayDye,
        LightGrayDye,
        CyanDye,
        PurpleDye,
        BlueDye,
        BrownDye,
        GreenDye,
        RedDye,
        BlackDye
    )

val Items.BlackDye: Item
    get() = Item(Key.key("minecraft:black_dye"))
val Items.BlueDye: Item
    get() = Item(Key.key("minecraft:blue_dye"))
val Items.BrownDye: Item
    get() = Item(Key.key("minecraft:brown_dye"))
val Items.CyanDye: Item
    get() = Item(Key.key("minecraft:cyan_dye"))
val Items.GrayDye: Item
    get() = Item(Key.key("minecraft:gray_dye"))
val Items.GreenDye: Item
    get() = Item(Key.key("minecraft:green_dye"))
val Items.LightBlueDye: Item
    get() = Item(Key.key("minecraft:light_blue_dye"))
val Items.LightGrayDye: Item
    get() = Item(Key.key("minecraft:light_gray_dye"))
val Items.LimeDye: Item
    get() = Item(Key.key("minecraft:lime_dye"))
val Items.MagentaDye: Item
    get() = Item(Key.key("minecraft:magenta_dye"))
val Items.OrangeDye: Item
    get() = Item(Key.key("minecraft:orange_dye"))
val Items.PinkDye: Item
    get() = Item(Key.key("minecraft:pink_dye"))
val Items.PurpleDye: Item
    get() = Item(Key.key("minecraft:purple_dye"))
val Items.RedDye: Item
    get() = Item(Key.key("minecraft:red_dye"))
val Items.WhiteDye: Item
    get() = Item(Key.key("minecraft:white_dye"))
val Items.YellowDye: Item
    get() = Item(Key.key("minecraft:yellow_dye"))