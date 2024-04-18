package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun getItems(){
        val item0 = "Aaaa"
        val item1 = "Bbbb"
        val item2 = "Cccc"
        collection.addItem(Item(item0))
        collection.addItem(Item(item1))
        collection.addItem(Item(item2))

        assert(collection.get(1) == Item(item1))
        assert(collection.get(0) == Item(item0))
        assert(collection.get(2) == Item(item2))
    }

    @Test
    fun removeItems(){
        val itemname = "Blue"
        val itemname2 = "Red"
        collection.addItem(Item(itemname))
        collection.addItem(Item(itemname2))
        collection.remove(Item(itemname))
        assert(collection.get(0) == Item(itemname2))
    }

    @Test
    fun removeItemsFromEmptyList(){
        val item = "A"
        collection.remove(Item(item))
        assert(collection.size() == 0)
    }
    @Test
    fun removeItemNotInList(){
        val existingItem = "A"
        val nonexistingItem = "B"
        collection.addItem(Item(existingItem))
        collection.remove(Item(nonexistingItem))
        assert(collection.size() == 1)
        assert(collection.get(0) == Item(existingItem))
    }

}