package plutoproject.adventurekt.test

import plutoproject.adventurekt.component
import plutoproject.adventurekt.text.actions
import plutoproject.adventurekt.text.and
import plutoproject.adventurekt.text.componentPlaceholder
import plutoproject.adventurekt.text.mini
import plutoproject.adventurekt.text.miniMessage
import plutoproject.adventurekt.text.newlineAction
import plutoproject.adventurekt.text.provide
import plutoproject.adventurekt.text.replace
import plutoproject.adventurekt.text.replacements
import plutoproject.adventurekt.text.space
import plutoproject.adventurekt.text.strict
import plutoproject.adventurekt.text.style.bold
import plutoproject.adventurekt.text.style.darkPurple
import plutoproject.adventurekt.text.style.green
import plutoproject.adventurekt.text.style.italic
import plutoproject.adventurekt.text.style.red
import plutoproject.adventurekt.text.style.shadowDarkBlue
import plutoproject.adventurekt.text.style.strikethrough
import plutoproject.adventurekt.text.style.textGradient
import plutoproject.adventurekt.text.style.textMaterialGold
import plutoproject.adventurekt.text.style.textRed
import plutoproject.adventurekt.text.style.underlined
import plutoproject.adventurekt.text.style.yellow
import plutoproject.adventurekt.text.tags
import plutoproject.adventurekt.text.target
import plutoproject.adventurekt.text.text
import plutoproject.adventurekt.text.unparsedPlaceholder
import plutoproject.adventurekt.text.with
import plutoproject.adventurekt.text.without
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.DataComponentValue
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.Tag
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import plutoproject.adventurekt.componentList
import plutoproject.adventurekt.item.Items
import plutoproject.adventurekt.item.blocks.colorable.Bed
import plutoproject.adventurekt.item.blocks.colorable.RedBed
import plutoproject.adventurekt.item.items.colorable.Dye
import plutoproject.adventurekt.item.items.colorable.OrangeDye
import plutoproject.adventurekt.item.items.tool.DiamondPickaxe
import plutoproject.adventurekt.text.newline
import plutoproject.adventurekt.text.style.count
import plutoproject.adventurekt.text.style.data
import plutoproject.adventurekt.text.style.decoration
import plutoproject.adventurekt.text.style.shadowColor
import plutoproject.adventurekt.text.style.showItem
import plutoproject.adventurekt.text.style.style
import plutoproject.adventurekt.text.style.text
import plutoproject.adventurekt.text.style.textColor
import plutoproject.adventurekt.text.style.type
import plutoproject.adventurekt.text.style.undecoration

fun main() {
    val generalStyle = style {
        textColor("#66ccff")
        shadowColor(green)
        decoration(underlined)
        undecoration(italic)
    }
    val components: List<Component> = componentList {
        text("test result") provide generalStyle
        newline()
        text("second line") provide generalStyle
    }

    println(components.map { GsonComponentSerializer.gson().serialize(it) }.toList())
}

class ComponentV2Test {

    fun style1(audience: Audience) {
        val generalStyle = style {
            textColor("#66ccff")
            shadowColor(green)
            decoration(underlined)
            undecoration(italic)
        }

        component {
            miniMessage {
                strict()
                tags {
                    tag("aa", Tag.inserting(Component.text("aa")))
                }
                provide(MiniMessage.miniMessage()) // highest priority
            }

            actions {

                newlineAction {
                    it.value = null // clear the original component
                }

            }

            replacements {
                override()
                replacement {
                    once()
                    matchLiteral("fuck")
                    replace {
                        space()
                        text("****") with textRed and underlined
                        space()
                    }
                }
            }

            text { "supplier style" } with showItem(Key.key("minecraft:diamond"), 1) {
                data(Key.key("minecraft:enchantments"), DataComponentValue.removed())
            }
            text { true }
            text("aaa") with "#66ccff" and bold and strikethrough without italic and strikethrough
            text("color showcase") with textRed with shadowDarkBlue
            text("bedrock colors") with textMaterialGold

            text("better color usage") with red.text

            text("this is a super looooooooooooooooooooooong text to test gradient") with textGradient(red, green, yellow, darkPurple)

            // use component default mini message
            mini("<blue><bold>no extra data mini message")

            // use default mini message with custom placeholder and other things
            mini("<red> example, <name>, <events>") {
                target(audience)

                unparsedPlaceholder("name", "DeeChael")
                componentPlaceholder("events") {
                    text("No events here!")
                }
            }

            text("text") provide generalStyle

            newline()

            // some hover showItem event showcase
            text("normal item") with showItem {
                type(Items.DiamondPickaxe)
                count(2)
            }

            // colorable items
            // new style
            text("dye with") with showItem {
                type(Items.Dye.orange)
                type(Items.Bed.red) // replace orange dye with red bed
            }
            // old style
            text("dye with") with showItem {
                type(Items.OrangeDye)
                type(Items.RedBed)
            }
        }
    }

}