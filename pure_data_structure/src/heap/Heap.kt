package heap

interface Heap<Element> : Collection<Element> {

    fun peek(): Element? // Returns the main|max based on the heap implementation.

}