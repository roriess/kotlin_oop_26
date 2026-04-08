package org.example.stack
import org.example.list.SingleLinkedList

open class SingleLinkedStack: SingleLinkedList(), Stack {
    override fun push(value: Int) {
        add(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return removeLast()
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return peekLast()
    }

    override val isEmpty: Boolean
        get() = size == 0
}
