package org.example.list

class CustomArrayList(startSize: Int): CustomList {
    private var inner = IntArray(startSize)
    private var lastElementIndex = -1

    override operator fun get(index: Int): Int {
        if (index !in 0..lastElementIndex) {
            throw IndexOutOfBoundsException("Index $index out of bounds, size = $size")
        }
        return inner[index]
        }

    override operator fun set(index: Int, value: Int) {
        if (index !in 0..lastElementIndex) {
            throw IndexOutOfBoundsException("Index $index out of bounds, size = $size")
        }
        inner[index] = value
    }

    private fun resize(newSize: Int) {
        if (inner.size >= newSize) {
            throw IllegalArgumentException("Current size is bigger than $newSize")
        }
        val newInner = IntArray(newSize)
        for (i in 0..lastElementIndex) {
            newInner[i] = inner[i]
        }
        inner = newInner
    }

    override fun add(element: Int) {
        if (lastElementIndex + 1 >= inner.size) {
            if (inner.isEmpty()) {
                resize(2)
            } else {
                resize(inner.size * 2)
            }
        }
        lastElementIndex++
        inner[lastElementIndex] = element
    }

    private fun shiftElementsRight(startIndex: Int) {
        if (lastElementIndex + 1 >= inner.size) {
            resize(inner.size * 2)
        }
        var currentIndex = lastElementIndex + 1
        while (currentIndex > startIndex) {
            inner[currentIndex] = inner[currentIndex - 1]
            currentIndex--
        }
        lastElementIndex++
    }


    override fun addFirst(element: Int) {
        shiftElementsRight(0)
        inner[0] = element
    }

    private fun shiftElementsLeft(startIndex: Int) {
        for (i in startIndex..<lastElementIndex) {
            inner[i] = inner[i + 1]
        }
        inner[lastElementIndex] = 0
        lastElementIndex--
    }

    override fun remove(element: Int): Boolean {
        for (i in 0..lastElementIndex) {
            if (inner[i] == element) {
                shiftElementsLeft(i)
                return true
            }
        }
        return false
    }


    fun removeAt(index: Int) {
        if (index < 0 || index >= size) throw IndexOutOfBoundsException()
        shiftElementsLeft(index)
    }

    override fun indexOf(element: Int): Int {
        for (i in 0..lastElementIndex) {
            if (inner[i] == element) {
                return i
            }
        }
        return -1
    }

    override val size: Int
        get() {
            return lastElementIndex + 1
        }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var currentIndex = 0

            override fun hasNext(): Boolean {
                return currentIndex <= lastElementIndex
            }

            override fun next(): Int {
                if (!hasNext()) {
                    throw NoSuchElementException()
                }
                return inner[currentIndex++]
            }
        }
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}
