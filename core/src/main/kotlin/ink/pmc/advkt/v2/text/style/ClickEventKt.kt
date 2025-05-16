package ink.pmc.advkt.v2.text.style

import ink.pmc.advkt.v2.text.ComponentKt
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent



internal class ClickEventWithStyle(val clickEvent: ClickEvent) : WithStyle {
    override fun with(
        holder: ComponentKt,
        original: Component
    ): Component {
        return original.clickEvent(this.clickEvent)
    }
}

internal object ClickEventWithoutStyle : WithoutStyle {

    override fun without(
        holder: ComponentKt,
        original: Component
    ): Component {
        return original.clickEvent(null)
    }

}