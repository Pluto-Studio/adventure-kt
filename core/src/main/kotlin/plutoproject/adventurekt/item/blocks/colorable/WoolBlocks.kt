package plutoproject.adventurekt.item.blocks.colorable

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.ColorableBlockItem
import plutoproject.adventurekt.item.Items

val Items.Wool: ColorableBlockItem
    get() = ColorableBlockItem(
        WhiteWool,
        OrangeWool,
        MagentaWool,
        LightBlueWool,
        YellowWool,
        LimeWool,
        PinkWool,
        GrayWool,
        LightGrayWool,
        CyanWool,
        PurpleWool,
        BlueWool,
        BrownWool,
        GreenWool,
        RedWool,
        BlackWool,
    )

val Items.BlackWool: BlockItem
    get() = BlockItem(Key.key("minecraft:black_wool"), Key.key("minecraft:black_wool"))
val Items.BlueWool: BlockItem
    get() = BlockItem(Key.key("minecraft:blue_wool"), Key.key("minecraft:blue_wool"))
val Items.BrownWool: BlockItem
    get() = BlockItem(Key.key("minecraft:brown_wool"), Key.key("minecraft:brown_wool"))
val Items.CyanWool: BlockItem
    get() = BlockItem(Key.key("minecraft:cyan_wool"), Key.key("minecraft:cyan_wool"))
val Items.GrayWool: BlockItem
    get() = BlockItem(Key.key("minecraft:gray_wool"), Key.key("minecraft:gray_wool"))
val Items.GreenWool: BlockItem
    get() = BlockItem(Key.key("minecraft:green_wool"), Key.key("minecraft:green_wool"))
val Items.LightBlueWool: BlockItem
    get() = BlockItem(Key.key("minecraft:light_blue_wool"), Key.key("minecraft:light_blue_wool"))
val Items.LightGrayWool: BlockItem
    get() = BlockItem(Key.key("minecraft:light_gray_wool"), Key.key("minecraft:light_gray_wool"))
val Items.LimeWool: BlockItem
    get() = BlockItem(Key.key("minecraft:lime_wool"), Key.key("minecraft:lime_wool"))
val Items.MagentaWool: BlockItem
    get() = BlockItem(Key.key("minecraft:magenta_wool"), Key.key("minecraft:magenta_wool"))
val Items.OrangeWool: BlockItem
    get() = BlockItem(Key.key("minecraft:orange_wool"), Key.key("minecraft:orange_wool"))
val Items.PinkWool: BlockItem
    get() = BlockItem(Key.key("minecraft:pink_wool"), Key.key("minecraft:pink_wool"))
val Items.PurpleWool: BlockItem
    get() = BlockItem(Key.key("minecraft:purple_wool"), Key.key("minecraft:purple_wool"))
val Items.RedWool: BlockItem
    get() = BlockItem(Key.key("minecraft:red_wool"), Key.key("minecraft:red_wool"))
val Items.WhiteWool: BlockItem
    get() = BlockItem(Key.key("minecraft:white_wool"), Key.key("minecraft:white_wool"))
val Items.YellowWool: BlockItem
    get() = BlockItem(Key.key("minecraft:yellow_wool"), Key.key("minecraft:yellow_wool"))