package org.example.stack
import org.example.list.CustomArrayList

class ArrayListStack : Stack {
    private val stack = CustomArrayList(0)

    override fun push(value: Int) {
        stack.add(value)
    }

    private fun removeLast(): Int {
        val lastIndex = stack.size - 1
        val lastElement = stack[lastIndex]
        stack.removeAt(lastIndex)
        return lastElement
    }

    // Get and remove top item from stack
    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return removeLast()
    }

    // Get top item from stack
    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        val lastIndex = stack.size - 1
        return stack[lastIndex]
    }

    val size: Int get() = stack.size

    override val isEmpty: Boolean
        get() = size == 0

}