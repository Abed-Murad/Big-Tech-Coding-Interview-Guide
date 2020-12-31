package heap

interface Collection<Element> {
    var count: Int
        get
    val isEmpty: Boolean
        get() = count == 0

    fun insert(element: Element)

    fun remove(): Element?

    fun remove(index: Int): Element?
}

