package plutoproject.adventurekt.item.blocks.colorable.glass

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.BlockItem
import plutoproject.adventurekt.item.ColorableBlockItem
import plutoproject.adventurekt.item.Items

val Items.Glass: GlassBlockItem
    get() = GlassBlockItem(
        BlockItem(Key.key("minecraft:glass"), Key.key("minecraft:glass")),
        TintedGlass,
        WhiteStainedGlass,
        OrangeStainedGlass,
        MagentaStainedGlass,
        LightBlueStainedGlass,
        YellowStainedGlass,
        LimeStainedGlass,
        PinkStainedGlass,
        GrayStainedGlass,
        LightGrayStainedGlass,
        CyanStainedGlass,
        PurpleStainedGlass,
        BlueStainedGlass,
        BrownStainedGlass,
        GreenStainedGlass,
        RedStainedGlass,
        BlackStainedGlass,
    )
val Items.StainedGlass: ColorableBlockItem
    get() = ColorableBlockItem(
        WhiteStainedGlass,
        OrangeStainedGlass,
        MagentaStainedGlass,
        LightBlueStainedGlass,
        YellowStainedGlass,
        LimeStainedGlass,
        PinkStainedGlass,
        GrayStainedGlass,
        LightGrayStainedGlass,
        CyanStainedGlass,
        PurpleStainedGlass,
        BlueStainedGlass,
        BrownStainedGlass,
        GreenStainedGlass,
        RedStainedGlass,
        BlackStainedGlass,
    )

val Items.TintedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:tinted_glass"), Key.key("minecraft:tinted_glass"))

val Items.BlackStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:black_stained_glass"), Key.key("minecraft:black_stained_glass"))
val Items.BlueStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:blue_stained_glass"), Key.key("minecraft:blue_stained_glass"))
val Items.BrownStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:brown_stained_glass"), Key.key("minecraft:brown_stained_glass"))
val Items.CyanStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:cyan_stained_glass"), Key.key("minecraft:cyan_stained_glass"))
val Items.GrayStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:gray_stained_glass"), Key.key("minecraft:gray_stained_glass"))
val Items.GreenStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:green_stained_glass"), Key.key("minecraft:green_stained_glass"))
val Items.LightBlueStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:light_blue_stained_glass"), Key.key("minecraft:light_blue_stained_glass"))
val Items.LightGrayStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:light_gray_stained_glass"), Key.key("minecraft:light_gray_stained_glass"))
val Items.LimeStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:lime_stained_glass"), Key.key("minecraft:lime_stained_glass"))
val Items.MagentaStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:magenta_stained_glass"), Key.key("minecraft:magenta_stained_glass"))
val Items.OrangeStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:orange_stained_glass"), Key.key("minecraft:orange_stained_glass"))
val Items.PinkStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:pink_stained_glass"), Key.key("minecraft:pink_stained_glass"))
val Items.PurpleStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:purple_stained_glass"), Key.key("minecraft:purple_stained_glass"))
val Items.RedStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:red_stained_glass"), Key.key("minecraft:red_stained_glass"))
val Items.WhiteStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:white_stained_glass"), Key.key("minecraft:white_stained_glass"))
val Items.YellowStainedGlass: BlockItem
    get() = BlockItem(Key.key("minecraft:yellow_stained_glass"), Key.key("minecraft:yellow_stained_glass"))

open class GlassBlockItem(
    private val original: BlockItem,
    val tinted: BlockItem,
    val white: BlockItem,
    val orange: BlockItem,
    val magenta: BlockItem,
    val lightBlue: BlockItem,
    val yellow: BlockItem,
    val lime: BlockItem,
    val pink: BlockItem,
    val gray: BlockItem,
    val lightGray: BlockItem,
    val cyan: BlockItem,
    val purple: BlockItem,
    val blue: BlockItem,
    val brown: BlockItem,
    val green: BlockItem,
    val red: BlockItem,
    val black: BlockItem
): BlockItem(
    original.internalItemId,
    original.blockId
)