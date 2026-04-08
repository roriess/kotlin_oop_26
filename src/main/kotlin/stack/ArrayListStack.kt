package org.example.stack

class ArrayListStack : Stack {
    private val list = ArrayList<Int>()

    override fun push(value: Int) {
        list.add(value)
    }

    // Get and remove top item from stack
    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return list.removeAt(list.size - 1)
    }

    // Get top item from stack
    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return list[list.size - 1]
    }

    override val isEmpty: Boolean
        get() = list.isEmpty()

    override operator fun get(index: Int): Int {
        return list[index]
    }

    override operator fun set(index: Int, value: Int) {
        list[index] = value
    }

    override fun add(element: Int) {
        push(element)
    }

    override fun addFirst(element: Int) {
        list.add(0, element)
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