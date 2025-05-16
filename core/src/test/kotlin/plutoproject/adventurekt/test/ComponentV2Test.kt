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