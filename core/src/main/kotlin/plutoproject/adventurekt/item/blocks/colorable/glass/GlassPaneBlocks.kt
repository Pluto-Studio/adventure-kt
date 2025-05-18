package plutoproject.adventurekt.item.blocks.colorable.glass

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.ColorableBlockItem
import plutoproject.adventurekt.item.Items
import plutoproject.adventurekt.item.OriginableColorableBlockItem

val Items.GlassPane: OriginableColorableBlockItem
    get() = OriginableColorableBlockItem(
        BlockItem(Key.key("minecraft:glass_pane"), Key.key("minecraft:glass_pane")),
        WhiteStainedGlassPane,
        OrangeStainedGlassPane,
        MagentaStainedGlassPane,
        LightBlueStainedGlassPane,
        YellowStainedGlassPane,
        LimeStainedGlassPane,
        PinkStainedGlassPane,
        GrayStainedGlassPane,
        LightGrayStainedGlassPane,
        CyanStainedGlassPane,
        PurpleStainedGlassPane,
        BlueStainedGlassPane,
        BrownStainedGlassPane,
        GreenStainedGlassPane,
        RedStainedGlassPane,
        BlackStainedGlassPane,
    )

val Items.StainedGlassPane: ColorableBlockItem
    get() = ColorableBlockItem(
        WhiteStainedGlassPane,
        OrangeStainedGlassPane,
        MagentaStainedGlassPane,
        LightBlueStainedGlassPane,
        YellowStainedGlassPane,
        LimeStainedGlassPane,
        PinkStainedGlassPane,
        GrayStainedGlassPane,
        LightGrayStainedGlassPane,
        CyanStainedGlassPane,
        PurpleStainedGlassPane,
        BlueStainedGlassPane,
        BrownStainedGlassPane,
        GreenStainedGlassPane,
        RedStainedGlassPane,
        BlackStainedGlassPane,
    )

val Items.BlackStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:black_stained_glass_pane"), Key.key("minecraft:black_stained_glass_pane"))
val Items.BlueStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:blue_stained_glass_pane"), Key.key("minecraft:blue_stained_glass_pane"))
val Items.BrownStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:brown_stained_glass_pane"), Key.key("minecraft:brown_stained_glass_pane"))
val Items.CyanStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:cyan_stained_glass_pane"), Key.key("minecraft:cyan_stained_glass_pane"))
val Items.GrayStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:gray_stained_glass_pane"), Key.key("minecraft:gray_stained_glass_pane"))
val Items.GreenStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:green_stained_glass_pane"), Key.key("minecraft:green_stained_glass_pane"))
val Items.LightBlueStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:light_blue_stained_glass_pane"), Key.key("minecraft:light_blue_stained_glass_pane"))
val Items.LightGrayStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:light_gray_stained_glass_pane"), Key.key("minecraft:light_gray_stained_glass_pane"))
val Items.LimeStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:lime_stained_glass_pane"), Key.key("minecraft:lime_stained_glass_pane"))
val Items.MagentaStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:magenta_stained_glass_pane"), Key.key("minecraft:magenta_stained_glass_pane"))
val Items.OrangeStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:orange_stained_glass_pane"), Key.key("minecraft:orange_stained_glass_pane"))
val Items.PinkStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:pink_stained_glass_pane"), Key.key("minecraft:pink_stained_glass_pane"))
val Items.PurpleStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:purple_stained_glass_pane"), Key.key("minecraft:purple_stained_glass_pane"))
val Items.RedStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:red_stained_glass_pane"), Key.key("minecraft:red_stained_glass_pane"))
val Items.WhiteStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:white_stained_glass_pane"), Key.key("minecraft:white_stained_glass_pane"))
val Items.YellowStainedGlassPane: BlockItem
    get() = BlockItem(Key.key("minecraft:yellow_stained_glass_pane"), Key.key("minecraft:yellow_stained_glass_pane"))
