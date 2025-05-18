package plutoproject.adventurekt.item.blocks.colorable.banner

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.ColorableBlockItem
import plutoproject.adventurekt.item.Items

val Items.WallBanner: ColorableBlockItem
    get() = ColorableBlockItem(
        WhiteWallBanner,
        OrangeWallBanner,
        MagentaWallBanner,
        LightBlueWallBanner,
        YellowWallBanner,
        LimeWallBanner,
        PinkWallBanner,
        GrayWallBanner,
        LightGrayWallBanner,
        CyanWallBanner,
        PurpleWallBanner,
        BlueWallBanner,
        BrownWallBanner,
        GreenWallBanner,
        RedWallBanner,
        BlackWallBanner,
    )

val Items.BlackWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:black_banner"), Key.key("minecraft:black_wall_banner"))
val Items.BlueWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:blue_banner"), Key.key("minecraft:blue_wall_banner"))
val Items.BrownWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:brown_banner"), Key.key("minecraft:brown_wall_banner"))
val Items.CyanWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:cyan_banner"), Key.key("minecraft:cyan_wall_banner"))
val Items.GrayWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:gray_banner"), Key.key("minecraft:gray_wall_banner"))
val Items.GreenWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:green_banner"), Key.key("minecraft:green_wall_banner"))
val Items.LightBlueWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:light_blue_banner"), Key.key("minecraft:light_blue_wall_banner"))
val Items.LightGrayWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:light_gray_banner"), Key.key("minecraft:light_gray_wall_banner"))
val Items.LimeWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:lime_banner"), Key.key("minecraft:lime_wall_banner"))
val Items.MagentaWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:magenta_banner"), Key.key("minecraft:magenta_wall_banner"))
val Items.OrangeWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:orange_banner"), Key.key("minecraft:orange_wall_banner"))
val Items.PinkWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:pink_banner"), Key.key("minecraft:pink_wall_banner"))
val Items.PurpleWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:purple_banner"), Key.key("minecraft:purple_wall_banner"))
val Items.RedWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:red_banner"), Key.key("minecraft:red_wall_banner"))
val Items.WhiteWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:white_banner"), Key.key("minecraft:white_wall_banner"))
val Items.YellowWallBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:yellow_banner"), Key.key("minecraft:yellow_wall_banner"))