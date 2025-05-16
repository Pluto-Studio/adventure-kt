package ink.pmc.advkt.v2_old.book

import ink.pmc.advkt.v2_old.component.TextContainer
import net.kyori.adventure.inventory.Book
import net.kyori.adventure.text.Component

class BookKt {

    private var title: Component = Component.empty()
    private var author: Component = Component.empty()
    private var pages = mutableListOf<Component>()

    fun title(container: TextContainer.() -> Unit) {
        this.title = TextContainer().apply(container).build()
    }

    fun author(container: TextContainer.() -> Unit) {
        this.author = TextContainer().apply(container).build()
    }

    fun page(container: TextContainer.() -> Unit) {
        this.pages.add(TextContainer().apply(container).build())
    }

    fun build(): Book {
        return Book.book(this.title, this.author, this.pages.toList())
    }

}

fun book(builder: BookKt.() -> Unit): Book {
    return BookKt().apply(builder).build()
}