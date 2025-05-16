package ink.pmc.advkt.v2_old.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver

class MiniMessageBuilder {

    private val builder = MiniMessage.builder()
    private var provided: MiniMessage? = null

    fun provide(miniMessage: MiniMessage) {
        this.provided = miniMessage
    }

    fun strict() {
        this.builder.strict(true)
    }

    fun tags(builder: TagResolver.Builder.() -> Unit) {
        this.builder.tags(TagResolver.builder().apply(builder).build())
    }

    fun debug(debugger: String.() -> Unit) {
        this.builder.debug(debugger)
    }

    fun postProcessor(processor: Component.() -> Component) {
        this.builder.postProcessor(processor)
    }

    fun preProcessor(processor: String.() -> String) {
        this.builder.preProcessor(processor)
    }

    fun build(): MiniMessage {
        return if (this.provided == null) {
            this.builder.build()
        } else {
            this.provided!!
        }
    }

}