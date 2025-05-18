package plutoproject.adventurekt.item.blocks.colorable

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.ColorableBlockItem
import plutoproject.adventurekt.item.Items

val Items.Bed: ColorableBlockItem
    get() = ColorableBlockItem(
        WhiteBed,
        OrangeBed,
        MagentaBed,
        LightBlueBed,
        YellowBed,
        LimeBed,
        PinkBed,
        GrayBed,
        LightGrayBed,
        CyanBed,
        PurpleBed,
        BlueBed,
        BrownBed,
        GreenBed,
        RedBed,
        BlackBed,
    )

val Items.BlackBed: BlockItem
    get() = BlockItem(Key.key("minecraft:black_bed"), Key.key("minecraft:black_bed"))
val Items.BlueBed: BlockItem
    get() = BlockItem(Key.key("minecraft:blue_bed"), Key.key("minecraft:blue_bed"))
val Items.BrownBed: BlockItem
    get() = BlockItem(Key.key("minecraft:brown_bed"), Key.key("minecraft:brown_bed"))
val Items.CyanBed: BlockItem
    get() = BlockItem(Key.key("minecraft:cyan_bed"), Key.key("minecraft:cyan_bed"))
val Items.GrayBed: BlockItem
    get() = BlockItem(Key.key("minecraft:gray_bed"), Key.key("minecraft:gray_bed"))
val Items.GreenBed: BlockItem
    get() = BlockItem(Key.key("minecraft:green_bed"), Key.key("minecraft:green_bed"))
val Items.LightBlueBed: BlockItem
    get() = BlockItem(Key.key("minecraft:light_blue_bed"), Key.key("minecraft:light_blue_bed"))
val Items.LightGrayBed: BlockItem
    get() = BlockItem(Key.key("minecraft:light_gray_bed"), Key.key("minecraft:light_gray_bed"))
val Items.LimeBed: BlockItem
    get() = BlockItem(Key.key("minecraft:lime_bed"), Key.key("minecraft:lime_bed"))
val Items.MagentaBed: BlockItem
    get() = BlockItem(Key.key("minecraft:magenta_bed"), Key.key("minecraft:magenta_bed"))
val Items.OrangeBed: BlockItem
    get() = BlockItem(Key.key("minecraft:orange_bed"), Key.key("minecraft:orange_bed"))
val Items.PinkBed: BlockItem
    get() = BlockItem(Key.key("minecraft:pink_bed"), Key.key("minecraft:pink_bed"))
val Items.PurpleBed: BlockItem
    get() = BlockItem(Key.key("minecraft:purple_bed"), Key.key("minecraft:purple_bed"))
val Items.RedBed: BlockItem
    get() = BlockItem(Key.key("minecraft:red_bed"), Key.key("minecraft:red_bed"))
val Items.WhiteBed: BlockItem
    get() = BlockItem(Key.key("minecraft:white_bed"), Key.key("minecraft:white_bed"))
val Items.YellowBed: BlockItem
    get() = BlockItem(Key.key("minecraft:yellow_bed"), Key.key("minecraft:yellow_bed"))