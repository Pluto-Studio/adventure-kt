package plutoproject.adventurekt.text.style

import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.DataComponentValue
import net.kyori.adventure.text.event.HoverEvent
import plutoproject.adventurekt.component
import plutoproject.adventurekt.text.ComponentKt
import java.util.UUID

fun hoverEvent(): WithoutStyle {
    return HoverEventWithoutStyle
}

fun showText(string: String): WithStyle {
    return HoverEventWithStyle(HoverEvent.showText(Component.text(string)))
}

fun showText(component: Component): WithStyle {
    return HoverEventWithStyle(HoverEvent.showText(component))
}

fun showText(builder: ComponentKt.() -> Unit): WithStyle {
    return HoverEventWithStyle(HoverEvent.showText(component(builder)))
}

fun showItem(id: Keyed, count: Int, data: ShowItemBuilder.() -> Unit = {}): WithStyle {
    return HoverEventWithStyle(HoverEvent.showItem(ShowItemBuilder(id, count).apply(data).build()))
}

fun showEntity(id: Keyed, uuid: UUID, name: (ComponentKt.() -> Unit)? = null): WithStyle {
    return if (name == null) {
        return HoverEventWithStyle(HoverEvent.showEntity(id, uuid))
    } else {
        return HoverEventWithStyle(HoverEvent.showEntity(id, uuid, component(name)))
    }
}

class ShowItemBuilder(
    private val id: Keyed,
    private val count: Int
) {

    internal val dataComponents: MutableMap<Key, DataComponentValue> = mutableMapOf()

    internal fun build(): HoverEvent.ShowItem {
        return HoverEvent.ShowItem.showItem(id, count, dataComponents.toMap())
    }

}

fun ShowItemBuilder.data(key: Key, value: DataComponentValue) {
    this.dataComponents[key] = value
}

internal class HoverEventWithStyle(val hoverEvent: HoverEvent<*>) : WithStyle {
    override fun with(
        holder: ComponentKt,
        original: Component
    ): Component {
        return original.hoverEvent(this.hoverEvent)
    }
}

internal object HoverEventWithoutStyle : WithoutStyle {

    override fun without(
        holder: ComponentKt,
        original: Component
    ): Component {
        return original.hoverEvent(null)
    }

}