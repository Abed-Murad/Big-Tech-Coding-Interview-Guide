# Kotlin Concepts

* **What are suspending function?**
    - Functions that can return a single value asynchronously.
    - When using suspending functions, you don't have to worry about threading, the `Coroutines` API does that for you!

* **What are `Sequence<T>`?**
    - `Sequences` are very similar to lists.
    - But unlike lists, they are **lazily evaluated**, this means they produce values as you iterate over them, instead
      of producing them all at once.
    - `Sequence` uses `Iterator` under the hood and block while waiting for the next item.
    - Used with synchronous streams.

* **What are `Channels` in `Coroutines`?**
    - Used with asynchronous streams.
    - Conceptually, they are like pipes, you send items through one pipe and receive a response through the other.
    - `Hot Stream` produce values immediately.


* **What are Coroutines?**
    - `CoroutineScope` Keeps track of any coroutine you create using `lunch` or `async`
    - `lunch` & `async` are extension function on CoroutineScope.
    - `viewModelScope` cancels the coroutines when the viewModel is destroyed.
    - `lifecycleScope` used with `lifeCycleOwner`.
    - `CoroutineContext` an index set of elements that define the behavior of a Coroutine. There are 4 elements that you
      can use and combine in a `CoroutineContext`:
        - `CoroutineDispatcher` Dispatches work to the appropriate `Thread`
            - `Dispatcher.IO` Disk and I/O operations
            - `Dispatcher.Default` CPU-intensive tasks
            - `Dispatcher.Main` For everything else (UI or non-blocking code)
        - `CoroutineExceptionHander` (optional) Handles un-caught exceptions.
        - `CoroutineName` Gives a name for `Coroutine`, useful for debugging
        - `Job` Controls the life-cycle of the `Coroutine`.
    - to change the `CoroutineContext` form inside the `Coroutine` use `withContext()`.

* **What are `Job` in `Coroutine`?**
    - A new `Coroutine` returns a `Job` and you can use this job to control the `Coroutine` life-cycle.
    - `SupervisorJob` used to avoid falling the other children of one child failed.

* **What is Kotlin `Flow`?**
    - A `Flow` is a type that can emit multiple values sequentially, as apposed to suspend functions that return only a
      single value ex: you can use `Flow` to receive live updates from a database.
    - `Flows` are built on top of `Coroutines` and can provide multiple values.
    - `Flow` is an implementation of **cold streams**, powered by kotlin `Coroutines`!
    - There are three entities involved in the `Flow` stream of data:
        - Producer: that produces the data
        - (Optional) Intermediaries: can modify each value emitted into the stream
        - Consumer: Consumes the values of the stream.

* **What is structured concurrency in `Coroutines` & `Flow`?**
    - With structured concurrency, `Coroutines` liv for a limited amount of time, this time is connected to
      the `CoroutineScope` you start you `Coroutines` in.
    - When you cancel the scope, you also release any running coroutines, the same rule apply for Kotlin `Flow` as well. 
    - It's basically a garbage collector for `Coroutines`.
    