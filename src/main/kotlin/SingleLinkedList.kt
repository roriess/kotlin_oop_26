package org.example

class SingleLinkedList : CustomList {

    private class Node(var value: Int, var next: Node? = null)

    private var head: Node? = null
    private var _size = 0

    override val size: Int
        get() = _size

    override fun add(element: Int) {
        val newNode = Node(element, null)
        if (head == null) {
            addFirst(element)
        } else {
            var currentNode = head
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = newNode
            _size++
        }
    }

    override operator fun set(index: Int, value: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index $index out of bounds for size $size")
        }
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null) {
            if (currentIndex == index) {
                currentNode.value = value
                return
            }
            currentIndex++
            currentNode = currentNode.next
        }
    }

    override fun addFirst(element: Int) {
        val newNode = Node(element, null)
        newNode.next = head
        head = newNode
        _size++
    }

    override operator fun get(index: Int): Int {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index $index out of bounds for size $size")
        }
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode.value
            }
            currentNode = currentNode.next
            currentIndex++
        }
        return -1
    }

    override fun indexOf(element: Int): Int {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null) {
            if (currentNode.value == element) {
                return currentIndex
            }
            currentIndex++
            currentNode = currentNode.next
        }
        return -1
    }

    override fun remove(element: Int): Boolean {
        if (head?.value == element) {
            head = head?.next
            _size--
            return true
        }
        var currentNode = head
        var previousNode: Node? = null
        while (currentNode != null) {
            if (currentNode.value == element) {
                previousNode?.next = currentNode.next
                _size--
                return true
            }
            previousNode = currentNode
            currentNode = currentNode.next
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            var currentNode = head
            override fun hasNext(): Boolean {
                return currentNode != null
            }
            override fun next(): Int {
                if (currentNode == null) {
                    throw NoSuchElementException()
                }
                val currentNodeValue = currentNode!!.value
                currentNode = currentNode!!.next
                return currentNodeValue
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also{ it.add(item) }
            }
    }
}