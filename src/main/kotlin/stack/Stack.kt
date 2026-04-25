package org.example.stack

interface Stack {
    // Add item to stack
    fun push(value: Int)

    // Get and remove top item from stack
    fun pop(): Int

    // Get top item from stack
    fun peek(): Int

    val isEmpty: Boolean
}