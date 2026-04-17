package org.example.stack
import org.example.list.CustomArrayList

class ArrayListStack : Stack {
    private val list = CustomArrayList(0)

    override fun push(value: Int) {
        list.add(value)
    }

    // Get and remove top item from stack
    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        val lastElement = get(list.size - 1)
        list.remove(lastElement)
        return lastElement
    }

    // Get top item from stack
    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return list[list.size - 1]
    }

    override val isEmpty: Boolean
        get() = size == 0

    override operator fun get(index: Int): Int {
        return list[index]
    }

    override operator fun set(index: Int, value: Int) {
        list[index] = value
    }

    override fun add(element: Int) {
        list.add(element)
    }

    override fun addFirst(element: Int) {
        list.addFirst(element)
    }

    override fun remove(element: Int): Boolean {
        return list.remove(element)
    }

    override fun indexOf(element: Int): Int {
        return list.indexOf(element)
    }

    override val size: Int
        get() = list.size

    override fun iterator(): Iterator<Int> {
        return list.iterator()
    }
}