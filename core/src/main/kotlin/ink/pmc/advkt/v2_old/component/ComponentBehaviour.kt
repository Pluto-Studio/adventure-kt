package ink.pmc.advkt.v2_old.component

import net.kyori.adventure.text.Component

interface ComponentBehaviour {

    fun newline(container: ComponentContainer): Component

    fun space(container: ComponentContainer): Component

    fun empty(container: ComponentContainer): Component

}

class ComponentBehaviourBuilder {

    private var newlineBehaviour: (ComponentContainer) -> Component = { Component.newline() }
    private var spaceBehaviour: (ComponentContainer) -> Component = { Component.space() }
    private var emptyBehaviour: (ComponentContainer) -> Component = { Component.empty() }

    fun newline(behaviour: ComponentContainer.() -> Component) {
        this.newlineBehaviour = { behaviour(it) }
    }

    fun space(behaviour: (ComponentContainer) -> Component) {
        this.spaceBehaviour = { behaviour(it) }
    }

    fun empty(behaviour: (ComponentContainer) -> Component) {
        this.emptyBehaviour = { behaviour(it) }
    }

    fun build(): ComponentBehaviour {
        return ComponentBehaviourImpl(
            this.newlineBehaviour,
            this.spaceBehaviour,
            this.emptyBehaviour
        )
    }

}

private class ComponentBehaviourImpl(
    private val newlineBehaviour: (ComponentContainer) -> Component,
    private val spaceBehaviour: (ComponentContainer) -> Component,
    private val emptyBehaviour: (ComponentContainer) -> Component,
) : ComponentBehaviour {

    override fun newline(container: ComponentContainer): Component {
        return this.newlineBehaviour(container)
    }

    override fun space(container: ComponentContainer): Component {
        return this.spaceBehaviour(container)
    }

    override fun empty(container: ComponentContainer): Component {
        return this.emptyBehaviour(container)
    }

}

val DefaultComponentBehaviour: ComponentBehaviour = ComponentBehaviourImpl(
    { Component.newline() },
    { Component.space() },
    { Component.empty() }
)