package org.example.stack
import org.example.list.SingleLinkedList

open class SingleLinkedStack: SingleLinkedList(), Stack {
    override fun push(value: Int) {
        addFirst(value)
    }

    private fun removeFirst(): Int {
        if (head == null) throw NoSuchElementException("Stack is empty")
        val value = head!!.value
        head = head?.next
        if (head == null) tail = null
        _size--
        return value
    }

    override fun pop(): Int {
        if (isEmpty) throw NoSuchElementException("Stack is empty")
        return removeFirst()
    }

    private fun peekFirst(): Int {
        if (head == null) throw NoSuchElementException()
        return head!!.value
    }

    override fun peek(): Int {
        if (isEmpty) throw NoSuchElementException("Stack is empty")
        return peekFirst()
    }

    override val isEmpty: Boolean
        get() = size == 0
}