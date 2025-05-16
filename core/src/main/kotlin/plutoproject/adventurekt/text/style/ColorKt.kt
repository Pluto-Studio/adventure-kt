package plutoproject.adventurekt.text.style

import plutoproject.adventurekt.text.ComponentKt
import plutoproject.adventurekt.text.TextComponentKt
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.ShadowColor
import net.kyori.adventure.text.format.TextColor

data class ColorKt(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int
)

data class GradientColorKt(
    val colors: List<ColorKt>
)

/////////////////////////////////////////////////////////////////////////////////////
// COLOR START
/////////////////////////////////////////////////////////////////////////////////////

fun gradient(first: ColorKt, second: ColorKt, vararg extra: ColorKt): GradientColorKt {
    val colors = mutableListOf<ColorKt>()
    colors.add(first)
    colors.add(second)
    colors.addAll(extra)
    return GradientColorKt(colors.toList())
}

fun rgb(r: Int, g: Int, b: Int): ColorKt {
    return ColorKt(r, g, b, 255)
}

fun rgba(r: Int, g: Int, b: Int, a: Int): ColorKt {
    return ColorKt(r, g, b, a)
}

fun hex(hex: String): ColorKt {
    return if (hex.startsWith("#")) {
        if (hex.length == 9) {
            val color = ShadowColor.fromHexString(hex) ?: throw IllegalArgumentException("Invalid hex string: $hex")
            return ColorKt(color.red(), color.green(), color.blue(), color.alpha())
        } else if (hex.length == 7) {
            val color = TextColor.fromHexString(hex) ?: throw IllegalArgumentException("Invalid hex string: $hex")
            return ColorKt(color.red(), color.green(), color.blue(), 255)
        } else {
            throw IllegalArgumentException("Invalid hex string: $hex")
        }
    } else {
        if (hex.length == 8) {
            val color = ShadowColor.fromHexString("#$hex") ?: throw IllegalArgumentException("Invalid hex string: #$hex")
            return ColorKt(color.red(), color.green(), color.blue(), color.alpha())
        } else if (hex.length == 6) {
            val color = TextColor.fromHexString("#$hex") ?: throw IllegalArgumentException("Invalid hex string: #$hex")
            return ColorKt(color.red(), color.green(), color.blue(), 255)
        } else {
            throw IllegalArgumentException("Invalid hex string: $hex")
        }
    }
}

val transparent: ColorKt = ColorKt(0, 0, 0, 0)

val black: ColorKt = ColorKt(0, 0, 0, 255)
val blackBG: ColorKt = ColorKt(0, 0, 0, 255)

val darkBlue: ColorKt = ColorKt(0, 0, 170, 255)
val darkBlueBG: ColorKt = ColorKt(0, 0, 42, 255)

val darkGreen: ColorKt = ColorKt(0, 170, 0, 255)
val darkGreenBG: ColorKt = ColorKt(0, 42, 0, 255)

val darkAqua: ColorKt = ColorKt(0, 170, 170, 255)
val darkAquaBG: ColorKt = ColorKt(0, 42, 42, 255)

val darkRed: ColorKt = ColorKt(170, 0, 0, 255)
val darkRedBG: ColorKt = ColorKt(42, 0, 0, 255)

val darkPurple: ColorKt = ColorKt(170, 0, 170, 255)
val darkPurpleBG: ColorKt = ColorKt(42, 0, 42, 255)

val gold: ColorKt = ColorKt(255, 170, 0, 255)
val goldBG: ColorKt = ColorKt(64, 42, 0, 255)

val gray: ColorKt = ColorKt(170, 170, 170, 255)
val grayBG: ColorKt = ColorKt(42, 42, 42, 255)

val grayBedrockEdition: ColorKt = ColorKt(198, 198, 198, 255)
val grayBedrockEditionBG: ColorKt = ColorKt(49, 49, 49, 255)

val darkGray: ColorKt = ColorKt(85, 85, 85, 255)
val darkGrayBG: ColorKt = ColorKt(21, 21, 21, 255)

val blue: ColorKt = ColorKt(85, 85, 255, 255)
val blueBG: ColorKt = ColorKt(21, 21, 63, 255)

val green: ColorKt = ColorKt(85, 255, 85, 255)
val greenBG: ColorKt = ColorKt(21, 63, 21, 255)

val aqua: ColorKt = ColorKt(85, 255, 255, 255)
val aquaBG: ColorKt = ColorKt(21, 63, 63, 255)

val red: ColorKt = ColorKt(255, 85, 85, 255)
val redBG: ColorKt = ColorKt(63, 21, 21, 255)

val lightPurple: ColorKt = ColorKt(255, 85, 255, 255)
val lightPurpleBG: ColorKt = ColorKt(63, 21, 63, 255)

val yellow: ColorKt = ColorKt(255, 255, 85, 255)
val yellowBG: ColorKt = ColorKt(63, 63, 21, 255)

val white: ColorKt = ColorKt(255, 255, 255, 255)
val whiteBG: ColorKt = ColorKt(63, 63, 63, 255)

// BEDROCK START
val minecoinGold: ColorKt = ColorKt(221, 214, 5, 255)
val minecoinGoldBG: ColorKt = ColorKt(55, 53, 1, 255)

val materialQuartz: ColorKt = ColorKt(227, 212, 209, 255)
val materialQuartzBG: ColorKt = ColorKt(56, 53, 52, 255)

val materialIron: ColorKt = ColorKt(206, 202, 202, 255)
val materialIronBG: ColorKt = ColorKt(51, 50, 50, 255)

val materialNetherite: ColorKt = ColorKt(68, 58, 59, 255)
val materialNetheriteBG: ColorKt = ColorKt(17, 14, 14, 255)

val materialRedstone: ColorKt = ColorKt(151, 22, 7, 255)
val materialRedstoneBG: ColorKt = ColorKt(37, 5, 1, 255)

val materialCopper: ColorKt = ColorKt(180, 104, 77, 255)
val materialCopperBG: ColorKt = ColorKt(45, 26, 19, 255)

val materialGold: ColorKt = ColorKt(222, 177, 45, 255)
val materialGoldBG: ColorKt = ColorKt(55, 44, 11, 255)

val materialEmerald: ColorKt = ColorKt(17, 160, 54, 255)
val materialEmeraldBG: ColorKt = ColorKt(4, 40, 13, 255)

val materialDiamond: ColorKt = ColorKt(44, 186, 168, 255)
val materialDiamondBG: ColorKt = ColorKt(11, 46, 42, 255)

val materialLapis: ColorKt = ColorKt(33, 73, 123, 255)
val materialLapisBG: ColorKt = ColorKt(8, 18, 30, 255)

val materialAmethyst: ColorKt = ColorKt(154, 92, 198, 255)
val materialAmethystBG: ColorKt = ColorKt(38, 23, 49, 255)

val materialResin: ColorKt = ColorKt(235, 114, 20, 255)
val materialResinBG: ColorKt = ColorKt(59, 29, 5, 255)

// BEDROCK END

/////////////////////////////////////////////////////////////////////////////////////
// COLOR END
/////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////
// TEXT COLOR START
/////////////////////////////////////////////////////////////////////////////////////

val textColor: WithoutStyle = ColorWithoutStyle

fun textGradient(first: ColorKt, second: ColorKt, vararg extra: ColorKt): WithStyle {
    return GradientColorWithStyle(gradient(first, second, *extra).colors.map { it.toTextColor() })
}

fun textRgb(r: Int, g: Int, b: Int): WithStyle {
    return ColorWithStyle(rgb(r, g, b).toTextColor())
}

fun textRgba(r: Int, g: Int, b: Int, a: Int): WithStyle {
    return ColorWithStyle(rgba(r, g, b, a).toTextColor())
}

fun textHex(hex: String): WithStyle {
    return ColorWithStyle(hex(hex).toTextColor())
}

val textBlack: WithStyle = ColorWithStyle(black.toTextColor())
val textBlackBG: WithStyle = ColorWithStyle(blackBG.toTextColor())

val textDarkBlue: WithStyle = ColorWithStyle(darkBlue.toTextColor())
val textDarkBlueBG: WithStyle = ColorWithStyle(darkBlueBG.toTextColor())

val textDarkGreen: WithStyle = ColorWithStyle(darkGreen.toTextColor())
val textDarkGreenBG: WithStyle = ColorWithStyle(darkGreenBG.toTextColor())

val textDarkAqua: WithStyle = ColorWithStyle(darkAqua.toTextColor())
val textDarkAquaBG: WithStyle = ColorWithStyle(darkAquaBG.toTextColor())

val textDarkRed: WithStyle = ColorWithStyle(darkRed.toTextColor())
val textDarkRedBG: WithStyle = ColorWithStyle(darkRedBG.toTextColor())

val textDarkPurple: WithStyle = ColorWithStyle(darkPurple.toTextColor())
val textDarkPurpleBG: WithStyle = ColorWithStyle(darkPurpleBG.toTextColor())

val textGold: WithStyle = ColorWithStyle(gold.toTextColor())
val textGoldBG: WithStyle = ColorWithStyle(goldBG.toTextColor())

val textGray: WithStyle = ColorWithStyle(gray.toTextColor())
val textGrayBG: WithStyle = ColorWithStyle(grayBG.toTextColor())

val textGrayBedrockEdition: WithStyle = ColorWithStyle(grayBedrockEdition.toTextColor())
val textGrayBedrockEditionBG: WithStyle = ColorWithStyle(grayBedrockEditionBG.toTextColor())

val textDarkGray: WithStyle = ColorWithStyle(darkGray.toTextColor())
val textDarkGrayBG: WithStyle = ColorWithStyle(darkGrayBG.toTextColor())

val textBlue: WithStyle = ColorWithStyle(blue.toTextColor())
val textBlueBG: WithStyle = ColorWithStyle(blueBG.toTextColor())

val textGreen: WithStyle = ColorWithStyle(green.toTextColor())
val textGreenBG: WithStyle = ColorWithStyle(greenBG.toTextColor())

val textAqua: WithStyle = ColorWithStyle(aqua.toTextColor())
val textAquaBG: WithStyle = ColorWithStyle(aquaBG.toTextColor())

val textRed: WithStyle = ColorWithStyle(red.toTextColor())
val textRedBG: WithStyle = ColorWithStyle(redBG.toTextColor())

val textLightPurple: WithStyle = ColorWithStyle(lightPurple.toTextColor())
val textLightPurpleBG: WithStyle = ColorWithStyle(lightPurpleBG.toTextColor())

val textYellow: WithStyle = ColorWithStyle(yellow.toTextColor())
val textYellowBG: WithStyle = ColorWithStyle(yellowBG.toTextColor())

val textWhite: WithStyle = ColorWithStyle(white.toTextColor())
val textWhiteBG: WithStyle = ColorWithStyle(whiteBG.toTextColor())

// BEDROCK START
val textMinecoinGold: WithStyle = ColorWithStyle(minecoinGold.toTextColor())
val textMinecoinGoldBG: WithStyle = ColorWithStyle(minecoinGoldBG.toTextColor())

val textMaterialQuartz: WithStyle = ColorWithStyle(materialQuartz.toTextColor())
val textMaterialQuartzBG: WithStyle = ColorWithStyle(materialQuartzBG.toTextColor())

val textMaterialIron: WithStyle = ColorWithStyle(materialIron.toTextColor())
val textMaterialIronBG: WithStyle = ColorWithStyle(materialIronBG.toTextColor())

val textMaterialNetherite: WithStyle = ColorWithStyle(materialNetherite.toTextColor())
val textMaterialNetheriteBG: WithStyle = ColorWithStyle(materialNetheriteBG.toTextColor())

val textMaterialRedstone: WithStyle = ColorWithStyle(materialRedstone.toTextColor())
val textMaterialRedstoneBG: WithStyle = ColorWithStyle(materialRedstoneBG.toTextColor())

val textMaterialCopper: WithStyle = ColorWithStyle(materialCopper.toTextColor())
val textMaterialCopperBG: WithStyle = ColorWithStyle(materialCopperBG.toTextColor())

val textMaterialGold: WithStyle = ColorWithStyle(materialGold.toTextColor())
val textMaterialGoldBG: WithStyle = ColorWithStyle(materialGoldBG.toTextColor())

val textMaterialEmerald: WithStyle = ColorWithStyle(materialEmerald.toTextColor())
val textMaterialEmeraldBG: WithStyle = ColorWithStyle(materialEmeraldBG.toTextColor())

val textMaterialDiamond: WithStyle = ColorWithStyle(materialDiamond.toTextColor())
val textMaterialDiamondBG: WithStyle = ColorWithStyle(materialDiamondBG.toTextColor())

val textMaterialLapis: WithStyle = ColorWithStyle(materialLapis.toTextColor())
val textMaterialLapisBG: WithStyle = ColorWithStyle(materialLapisBG.toTextColor())

val textMaterialAmethyst: WithStyle = ColorWithStyle(materialAmethyst.toTextColor())
val textMaterialAmethystBG: WithStyle = ColorWithStyle(materialAmethystBG.toTextColor())

val textMaterialResin: WithStyle = ColorWithStyle(materialResin.toTextColor())
val textMaterialResinBG: WithStyle = ColorWithStyle(materialResinBG.toTextColor())
// BEDROCK END

/////////////////////////////////////////////////////////////////////////////////////
// TEXT COLOR END
/////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////
// SHADOW COLOR START
/////////////////////////////////////////////////////////////////////////////////////

val shadowColor: WithoutStyle = ShadowWithoutStyle

fun shadowRgb(r: Int, g: Int, b: Int): WithStyle {
    return ShadowWithStyle(rgb(r, g, b).toShadowColor())
}

fun shadowRgba(r: Int, g: Int, b: Int, a: Int): WithStyle {
    return ShadowWithStyle(rgba(r, g, b, a).toShadowColor())
}

fun shadowHex(hex: String): WithStyle {
    return ShadowWithStyle(hex(hex).toShadowColor())
}

val shadowTransparent: WithStyle = ShadowWithStyle(transparent.toShadowColor())

val shadowBlack: WithStyle = ShadowWithStyle(black.toShadowColor())
val shadowBlackBG: WithStyle = ShadowWithStyle(blackBG.toShadowColor())

val shadowDarkBlue: WithStyle = ShadowWithStyle(darkBlue.toShadowColor())
val shadowDarkBlueBG: WithStyle = ShadowWithStyle(darkBlueBG.toShadowColor())

val shadowDarkGreen: WithStyle = ShadowWithStyle(darkGreen.toShadowColor())
val shadowDarkGreenBG: WithStyle = ShadowWithStyle(darkGreenBG.toShadowColor())

val shadowDarkAqua: WithStyle = ShadowWithStyle(darkAqua.toShadowColor())
val shadowDarkAquaBG: WithStyle = ShadowWithStyle(darkAquaBG.toShadowColor())

val shadowDarkRed: WithStyle = ShadowWithStyle(darkRed.toShadowColor())
val shadowDarkRedBG: WithStyle = ShadowWithStyle(darkRedBG.toShadowColor())

val shadowDarkPurple: WithStyle = ShadowWithStyle(darkPurple.toShadowColor())
val shadowDarkPurpleBG: WithStyle = ShadowWithStyle(darkPurpleBG.toShadowColor())

val shadowGold: WithStyle = ShadowWithStyle(gold.toShadowColor())
val shadowGoldBG: WithStyle = ShadowWithStyle(goldBG.toShadowColor())

val shadowGray: WithStyle = ShadowWithStyle(gray.toShadowColor())
val shadowGrayBG: WithStyle = ShadowWithStyle(grayBG.toShadowColor())

val shadowGrayBedrockEdition: WithStyle = ShadowWithStyle(grayBedrockEdition.toShadowColor())
val shadowGrayBedrockEditionBG: WithStyle = ShadowWithStyle(grayBedrockEditionBG.toShadowColor())

val shadowDarkGray: WithStyle = ShadowWithStyle(darkGray.toShadowColor())
val shadowDarkGrayBG: WithStyle = ShadowWithStyle(darkGrayBG.toShadowColor())

val shadowBlue: WithStyle = ShadowWithStyle(blue.toShadowColor())
val shadowBlueBG: WithStyle = ShadowWithStyle(blueBG.toShadowColor())

val shadowGreen: WithStyle = ShadowWithStyle(green.toShadowColor())
val shadowGreenBG: WithStyle = ShadowWithStyle(greenBG.toShadowColor())

val shadowAqua: WithStyle = ShadowWithStyle(aqua.toShadowColor())
val shadowAquaBG: WithStyle = ShadowWithStyle(aquaBG.toShadowColor())

val shadowRed: WithStyle = ShadowWithStyle(red.toShadowColor())
val shadowRedBG: WithStyle = ShadowWithStyle(redBG.toShadowColor())

val shadowLightPurple: WithStyle = ShadowWithStyle(lightPurple.toShadowColor())
val shadowLightPurpleBG: WithStyle = ShadowWithStyle(lightPurpleBG.toShadowColor())

val shadowYellow: WithStyle = ShadowWithStyle(yellow.toShadowColor())
val shadowYellowBG: WithStyle = ShadowWithStyle(yellowBG.toShadowColor())

val shadowWhite: WithStyle = ShadowWithStyle(white.toShadowColor())
val shadowWhiteBG: WithStyle = ShadowWithStyle(whiteBG.toShadowColor())

// BEDROCK START
val shadowMinecoinGold: WithStyle = ShadowWithStyle(minecoinGold.toShadowColor())
val shadowMinecoinGoldBG: WithStyle = ShadowWithStyle(minecoinGoldBG.toShadowColor())

val shadowMaterialQuartz: WithStyle = ShadowWithStyle(materialQuartz.toShadowColor())
val shadowMaterialQuartzBG: WithStyle = ShadowWithStyle(materialQuartzBG.toShadowColor())

val shadowMaterialIron: WithStyle = ShadowWithStyle(materialIron.toShadowColor())
val shadowMaterialIronBG: WithStyle = ShadowWithStyle(materialIronBG.toShadowColor())

val shadowMaterialNetherite: WithStyle = ShadowWithStyle(materialNetherite.toShadowColor())
val shadowMaterialNetheriteBG: WithStyle = ShadowWithStyle(materialNetheriteBG.toShadowColor())

val shadowMaterialRedstone: WithStyle = ShadowWithStyle(materialRedstone.toShadowColor())
val shadowMaterialRedstoneBG: WithStyle = ShadowWithStyle(materialRedstoneBG.toShadowColor())

val shadowMaterialCopper: WithStyle = ShadowWithStyle(materialCopper.toShadowColor())
val shadowMaterialCopperBG: WithStyle = ShadowWithStyle(materialCopperBG.toShadowColor())

val shadowMaterialGold: WithStyle = ShadowWithStyle(materialGold.toShadowColor())
val shadowMaterialGoldBG: WithStyle = ShadowWithStyle(materialGoldBG.toShadowColor())

val shadowMaterialEmerald: WithStyle = ShadowWithStyle(materialEmerald.toShadowColor())
val shadowMaterialEmeraldBG: WithStyle = ShadowWithStyle(materialEmeraldBG.toShadowColor())

val shadowMaterialDiamond: WithStyle = ShadowWithStyle(materialDiamond.toShadowColor())
val shadowMaterialDiamondBG: WithStyle = ShadowWithStyle(materialDiamondBG.toShadowColor())

val shadowMaterialLapis: WithStyle = ShadowWithStyle(materialLapis.toShadowColor())
val shadowMaterialLapisBG: WithStyle = ShadowWithStyle(materialLapisBG.toShadowColor())

val shadowMaterialAmethyst: WithStyle = ShadowWithStyle(materialAmethyst.toShadowColor())
val shadowMaterialAmethystBG: WithStyle = ShadowWithStyle(materialAmethystBG.toShadowColor())

val shadowMaterialResin: WithStyle = ShadowWithStyle(materialResin.toShadowColor())
val shadowMaterialResinBG: WithStyle = ShadowWithStyle(materialResinBG.toShadowColor())

/////////////////////////////////////////////////////////////////////////////////////
// SHADOW COLOR END
/////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////
// PRIVATE
/////////////////////////////////////////////////////////////////////////////////////

internal class ShadowWithStyle(val color: ShadowColor) : WithStyle {

    override fun with(holder: ComponentKt, original: Component): Component {
        return original.shadowColor(this.color)
    }

}

internal object ShadowWithoutStyle : WithoutStyle {

    override fun without(holder: ComponentKt, original: Component): Component {
        return original.shadowColor(null)
    }

}

internal class GradientColorWithStyle(val colors: List<TextColor>) : WithStyle {

    override fun with(holder: ComponentKt, original: Component): Component {
        val builder = StringBuilder()
        builder.append("<gradient")
        for (color in this.colors) {
            builder.append(":")
                .append(color.asHexString())
        }
        builder.append(">")
        builder.append((holder as TextComponentKt).miniMessage.serialize(original))
        builder.append("</gradient>")
        return holder.miniMessage.deserialize(builder.toString())
    }

}

internal class ColorWithStyle(val color: TextColor) : WithStyle {

    override fun with(holder: ComponentKt, original: Component): Component {
        return original.color(this.color)
    }

}

internal object ColorWithoutStyle : WithoutStyle {

    override fun without(holder: ComponentKt, original: Component): Component {
        return original.color(null)
    }

}

internal fun ColorKt.toTextColor(): TextColor {
    return TextColor.color(this.red, this.green, this.blue)
}

internal fun ColorKt.toShadowColor(): ShadowColor {
    return ShadowColor.shadowColor(this.red, this.green, this.blue, this.alpha)
}