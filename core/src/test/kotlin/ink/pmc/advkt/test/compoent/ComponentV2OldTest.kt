package ink.pmc.advkt.test.compoent

import ink.pmc.advkt.v2_old.component.component
import ink.pmc.advkt.v2_old.component.copyToClipboard
import ink.pmc.advkt.v2_old.component.hex
import ink.pmc.advkt.v2_old.component.italic
import ink.pmc.advkt.v2_old.component.openUrl
import ink.pmc.advkt.v2_old.component.red
import ink.pmc.advkt.v2_old.component.replace
import ink.pmc.advkt.v2_old.component.showText
import ink.pmc.advkt.v2_old.component.underlined
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.Tag

class ComponentV2OldTest {

    fun test1() {
        val example = component {
            behaviour {
                newline { Component.empty() }
            }

            miniMessage {
                strict()
                tags {
                    tag("aa", Tag.inserting(Component.text("aa")))
                }
                provide(MiniMessage.miniMessage()) // highest priority
            }

            replacements {
                override()
                replacement {
                    once()
                    matchLiteral("fuck")
                    replace {
                        text("****") with red() with underlined()
                    }
                }
            }

            text("example") with red() without italic() with copyToClipboard("Caobizhaowo") with showText {
                text("Ziwei")
            }

            component {
                text("another")
            }

            text("Test") with hex("#66ccff") with openUrl("https://www.github.com/DeeChael")


        }
    }

}