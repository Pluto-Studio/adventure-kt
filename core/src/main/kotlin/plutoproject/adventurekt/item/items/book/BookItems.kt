package plutoproject.adventurekt.item.items.book

import net.kyori.adventure.key.Key
import plutoproject.adventurekt.item.Item
import plutoproject.adventurekt.item.Items


val Items.Book: Item
    get() = Item(Key.key("minecraft:book"))
val Items.EnchantedBook: Item
    get() = Item(Key.key("minecraft:enchanted_book"))
val Items.KnowledgeBook: Item
    get() = Item(Key.key("minecraft:knowledge_book"))
val Items.WritableBook: Item
    get() = Item(Key.key("minecraft:writable_book"))
val Items.WrittenBook: Item
    get() = Item(Key.key("minecraft:written_book"))