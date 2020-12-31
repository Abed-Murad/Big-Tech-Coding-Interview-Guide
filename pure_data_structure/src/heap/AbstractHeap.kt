package heap

import java.util.*
import kotlin.collections.ArrayList

abstract class AbstractHeap<Element>() : Heap<Element> {

    val elements: ArrayList<Element> = ArrayList()

    override var count: Int
        get() = elements.size
        set(value) {}


    override fun insert(element: Element) {
        elements.add(element)
        siftUpd(count - 1)
    }

    private fun siftUpd(index: Int) {
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent]) > 0) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }

    override fun remove(): Element? {
        if (isEmpty) return null
        Collections.swap(elements, 0, count - 1)
        val item = elements.removeAt(count - 1)
        siftDown(0)
        return item
    }

    private fun siftDown(index: Int) {
        TODO("Not yet implemented")
    }

    override fun peek(): Element? {
        return elements.first()
    }


    private fun leftChildIndex(index: Int): Int {
        return (2 * index) + 1
    }

    private fun rightChildIndex(index: Int): Int {
        return (2 * index) + 2
    }

    private fun parentIndex(index: Int): Int {
        return (index - 1) / 2
    }

    abstract fun compare(a: Element, b: Element): Int


}