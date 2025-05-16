package ink.pmc.advkt.test.compoent

import ink.pmc.advkt.v2.component
import ink.pmc.advkt.v2.text.actions
import ink.pmc.advkt.v2.text.and
import ink.pmc.advkt.v2.text.cleanBuild
import ink.pmc.advkt.v2.text.componentPlaceholder
import ink.pmc.advkt.v2.text.mini
import ink.pmc.advkt.v2.text.miniMessage
import ink.pmc.advkt.v2.text.newlineAction
import ink.pmc.advkt.v2.text.provide
import ink.pmc.advkt.v2.text.replace
import ink.pmc.advkt.v2.text.replacements
import ink.pmc.advkt.v2.text.space
import ink.pmc.advkt.v2.text.strict
import ink.pmc.advkt.v2.text.style.bold
import ink.pmc.advkt.v2.text.style.darkPurple
import ink.pmc.advkt.v2.text.style.green
import ink.pmc.advkt.v2.text.style.italic
import ink.pmc.advkt.v2.text.style.red
import ink.pmc.advkt.v2.text.style.shadowDarkBlue
import ink.pmc.advkt.v2.text.style.strikethrough
import ink.pmc.advkt.v2.text.style.textGradient
import ink.pmc.advkt.v2.text.style.textMaterialGold
import ink.pmc.advkt.v2.text.style.textRed
import ink.pmc.advkt.v2.text.style.underlined
import ink.pmc.advkt.v2.text.style.yellow
import ink.pmc.advkt.v2.text.tags
import ink.pmc.advkt.v2.text.target
import ink.pmc.advkt.v2.text.text
import ink.pmc.advkt.v2.text.unparsedPlaceholder
import ink.pmc.advkt.v2.text.with
import ink.pmc.advkt.v2.text.without
import ink.pmc.advkt.v2.util.cleanBuild
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.Tag

class ComponentV2Test {

    fun style1(audience: Audience) {
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

            text("aaa") with "#66ccff" and bold and strikethrough without italic and strikethrough
            text("color showcase") with textRed with shadowDarkBlue
            text("bedrock colors") with textMaterialGold

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
        }
    }

}