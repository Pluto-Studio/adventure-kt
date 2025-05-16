package ink.pmc.advkt.v2.text

import ink.pmc.advkt.v2.component
import net.kyori.adventure.pointer.Pointered
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver

interface MiniMessageContext

fun MiniMessageContext.target(pointered: Pointered) {
    (this as MiniMessageContextKt).target(pointered)
}

fun MiniMessageContext.miniMessage(builder: MiniMessageBuilder.() -> Unit) {
    (this as MiniMessageContextKt).miniMessage = MiniMessageBuilderKt().apply(builder).build()
}

fun MiniMessageContext.componentPlaceholder(replacement: String, component: ComponentKt.() -> Unit) {
    (this as MiniMessageContextKt).tagResolvers.add(Placeholder.component(replacement, component(component)))
}

fun MiniMessageContext.unparsedPlaceholder(replacement: String, content: String) {
    (this as MiniMessageContextKt).tagResolvers.add(Placeholder.unparsed(replacement, content))
}

fun MiniMessageContext.parsedPlaceholder(replacement: String, content: String) {
    (this as MiniMessageContextKt).tagResolvers.add(Placeholder.parsed(replacement, content))
}

fun MiniMessageContext.parsedPlaceholder(tagResolver: TagResolver) {
    (this as MiniMessageContextKt).tagResolvers.add(tagResolver)
}

interface MiniMessageBuilder

fun MiniMessageBuilder.provide(miniMessage: MiniMessage) {
    (this as MiniMessageBuilderKt).provided = miniMessage
}

fun MiniMessageBuilder.strict() {
    (this as MiniMessageBuilderKt).builder.strict(true)
}

fun MiniMessageBuilder.tags(builder: TagResolver.Builder.() -> Unit) {
    (this as MiniMessageBuilderKt).builder.tags(TagResolver.builder().apply(builder).build())
}

fun MiniMessageBuilder.debug(debugger: String.() -> Unit) {
    (this as MiniMessageBuilderKt).builder.debug(debugger)
}

fun MiniMessageBuilder.postProcessor(processor: Component.() -> Component) {
    (this as MiniMessageBuilderKt).builder.postProcessor(processor)
}

fun MiniMessageBuilder.preProcessor(processor: String.() -> String) {
    (this as MiniMessageBuilderKt).builder.preProcessor(processor)
}

fun MiniMessageBuilder.build(): MiniMessage {
    return if ((this as MiniMessageBuilderKt).provided == null) {
        this.builder.build()
    } else {
        this.provided!!
    }
}

///////////////////////////////////////////////////////////////////////////////////////////
// PRIVATE
///////////////////////////////////////////////////////////////////////////////////////////

internal class MiniMessageContextKt : MiniMessageContext {

    internal var miniMessage: MiniMessage? = null
    internal var pointered: Pointered? = null
    internal val tagResolvers: MutableList<TagResolver> = mutableListOf()

}

internal class MiniMessageBuilderKt : MiniMessageBuilder {

    internal val builder = MiniMessage.builder()
    internal var provided: MiniMessage? = null

}