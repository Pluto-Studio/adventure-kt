package plutoproject.adventurekt.text

import plutoproject.adventurekt.util.Holder
import net.kyori.adventure.text.Component

interface ComponentActions {
    
}

fun ComponentKt.actions(actions: ComponentActions.() -> Unit) {
    (this as TextComponentKt).actions = ComponentActionsImpl().apply(actions)
}

///////////////////////////////////////////////////////////////////////////////////////////
// PRIVATE
///////////////////////////////////////////////////////////////////////////////////////////

internal class ComponentActionsImpl(
    internal var emptyAction: (Holder<Component>) -> Unit = {},
    internal var spaceAction: (Holder<Component>) -> Unit = {},
    internal var newlineAction: (Holder<Component>) -> Unit = {}
) : ComponentActions

fun ComponentActions.emptyAction(action: (Holder<Component>) -> Unit = {}) {
    (this as ComponentActionsImpl).emptyAction = action
}

fun ComponentActions.spaceAction(action: (Holder<Component>) -> Unit = {}) {
    (this as ComponentActionsImpl).spaceAction = action
}

fun ComponentActions.newlineAction(action: (Holder<Component>) -> Unit = {}) {
    (this as ComponentActionsImpl).newlineAction = action
}