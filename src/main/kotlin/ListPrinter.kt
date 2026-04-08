package org.example
import org.example.list.CustomList

object ListPrinter {
    fun printList(list: CustomList) {
        val iterator = list.iterator()
        if (!iterator.hasNext()) {
            println("[]")
            return
        }
        var printString = StringBuilder("[")
        while (iterator.hasNext()) {
            printString.append(iterator.next())
            if (iterator.hasNext()) {
                printString.append(", ")
            }
        }
        printString.append("]")
        println(printString)
    }
}