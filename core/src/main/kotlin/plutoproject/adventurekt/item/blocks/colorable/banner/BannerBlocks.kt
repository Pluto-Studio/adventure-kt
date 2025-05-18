package plutoproject.adventurekt.item.blocks.colorable.banner

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.ColorableBlockItem
import plutoproject.adventurekt.item.Items

val Items.Banner: ColorableBlockItem
    get() = ColorableBlockItem(
        WhiteBanner,
        OrangeBanner,
        MagentaBanner,
        LightBlueBanner,
        YellowBanner,
        LimeBanner,
        PinkBanner,
        GrayBanner,
        LightGrayBanner,
        CyanBanner,
        PurpleBanner,
        BlueBanner,
        BrownBanner,
        GreenBanner,
        RedBanner,
        BlackBanner,
    )

val Items.BlackBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:black_banner"), Key.key("minecraft:black_banner"))
val Items.BlueBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:blue_banner"), Key.key("minecraft:blue_banner"))
val Items.BrownBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:brown_banner"), Key.key("minecraft:brown_banner"))
val Items.CyanBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:cyan_banner"), Key.key("minecraft:cyan_banner"))
val Items.GrayBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:gray_banner"), Key.key("minecraft:gray_banner"))
val Items.GreenBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:green_banner"), Key.key("minecraft:green_banner"))
val Items.LightBlueBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:light_blue_banner"), Key.key("minecraft:light_blue_banner"))
val Items.LightGrayBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:light_gray_banner"), Key.key("minecraft:light_gray_banner"))
val Items.LimeBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:lime_banner"), Key.key("minecraft:lime_banner"))
val Items.MagentaBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:magenta_banner"), Key.key("minecraft:magenta_banner"))
val Items.OrangeBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:orange_banner"), Key.key("minecraft:orange_banner"))
val Items.PinkBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:pink_banner"), Key.key("minecraft:pink_banner"))
val Items.PurpleBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:purple_banner"), Key.key("minecraft:purple_banner"))
val Items.RedBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:red_banner"), Key.key("minecraft:red_banner"))
val Items.WhiteBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:white_banner"), Key.key("minecraft:white_banner"))
val Items.YellowBanner: BlockItem
    get() = BlockItem(Key.key("minecraft:yellow_banner"), Key.key("minecraft:yellow_banner"))