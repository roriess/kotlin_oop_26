package org.example.stack
import org.example.list.SingleLinkedList

open class SingleLinkedStack: SingleLinkedList(), Stack {
    override fun push(value: Int) {
        addFirst(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return removeFirst()
    }

    override fun peek(): Int {
        if (isEmpty) throw NoSuchElementException("Stack is empty")
        return peekFirst()
    }

    override val isEmpty: Boolean
        get() = size == 0
}
