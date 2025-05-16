package ink.pmc.advkt.v2.book

import ink.pmc.advkt.v2.component
import ink.pmc.advkt.v2.text.ComponentKt
import net.kyori.adventure.inventory.Book
import net.kyori.adventure.text.Component

class BookKt {

    internal var title: Component = Component.empty()
    internal var author: Component = Component.empty()
    internal var pages = mutableListOf<Component>()

}

fun BookKt.title(container: ComponentKt.() -> Unit) {
    this.title = component(container)
}

fun BookKt.author(container: ComponentKt.() -> Unit) {
    this.author = component(container)
}

fun BookKt.page(container: ComponentKt.() -> Unit) {
    this.pages.add(component(container))
}

fun BookKt.build(): Book {
    return Book.book(this.title, this.author, this.pages.toList())
}

fun book(builder: BookKt.() -> Unit): Book {
    return BookKt().apply(builder).build()
}