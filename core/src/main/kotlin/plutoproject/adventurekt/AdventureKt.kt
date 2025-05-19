package plutoproject.adventurekt

import plutoproject.adventurekt.text.ComponentKt
import plutoproject.adventurekt.text.TextComponentKt
import plutoproject.adventurekt.text.build
import net.kyori.adventure.text.Component
import plutoproject.adventurekt.text.actions
import plutoproject.adventurekt.text.newlineAction
import plutoproject.adventurekt.util.cleanBuild

fun component(content: ComponentKt.() -> Unit): Component {
    return TextComponentKt(Component.empty()).apply(content).build()
}

fun componentList(content: ComponentKt.() -> Unit): List<Component> {
    val list = mutableListOf<Component>()
    list.add(
        component {
            actions {
                newlineAction {
                    list.add(it.cleanBuild())
                }
            }
            content()
        }
    )
    return list.toList()
}