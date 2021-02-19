# Kotlin Concepts

* **What are suspending function?**
    - Can only be called form a Coroutine or another suspending function.
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
    - Use `asFlow()` to convert a `Channel` to a `Flow`.


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

* **What is structured concurrency in `Coroutines` & `Flow`?**
    - With structured concurrency, `Coroutines` liv for a limited amount of time, this time is connected to
      the `CoroutineScope` you start you `Coroutines` in.
    - When you cancel the scope, you also release any running coroutines, the same rule apply for Kotlin `Flow` as well.
    - It's basically a garbage collector for `Coroutines`.

* **What is Kotlin `Flow`?**
    - A `Flow` is a type that can emit multiple values sequentially, as apposed to suspend functions that return only a
      single value ex: you can use `Flow` to receive live updates from a database.
    - `Flows` are built on top of `Coroutines` and can provide multiple values.
    - `Flow` is an implementation of **cold streams**, powered by kotlin `Coroutines`!
    - There are three entities involved in the `Flow` stream of data:
        - Producer: that produces the data
        - (Optional) Intermediaries: can modify each value emitted into the stream
        - Consumer: Consumes the values of the stream.
    - Use `flowOf("Abed", "Murad", "Ali)` to create a flow from a fixed set of values.
    - Use `listOf("Jody", "Steve", "Lance", "Joe").asFlow()` to convert various collections and sequences to a `Flow`.
    - Use `asLiveData()` From `AndroidX KTX` Library to convert a `Flow` to `LiveData`.
    - The code inside a `Flow` builder does not run until the `Flow` data is collected.

* **What the types of Flow Builder?**
    1. `flowOf()` Used to create flow from a given set of items.
       ```kotlin
            flowOf(4, 2, 5, 1, 7)
            .collect {
            Log.d(TAG, it.toString())
            }
       ```
    2. `asFlow()` Extension function that helps to convert type into `Flow`
       ```kotlin
       (1..5).asFlow()
       .collect {
       Log.d(TAG, it.toString())
       }
       ```
    3. `flow{}` Congrats for being basic!
       ```kotlin
        flow {
        (0..10).forEach {
        emit(it)
        }
        }
        .collect {
        Log.d(TAG, it.toString())
        }       
        ```
    4. `channelFlow{}` Creates `Flow` with the elements using **send** provided by the builder itself.
       ```kotlin
        channelFlow {
        (0..10).forEach {
        send(it)
        }
        }
        .collect {
        Log.d(TAG, it.toString())
        }
       ```

* **What is `Flow` Operators?**
    - There are two types of operators **Intermediate** & **Terminal**
    - **Intermediate Operators** Colder Operators that only execute when you invoke a `terminal` operator on the final
      stream.
        - Ex `listOf("Jody", "Steve", "Lance", "Joe").asFlow()`
        - `map` Transforms each value to another value ex: `.map { name -> name.length }`.
        - `filter` Select values that meet a condition ex `.filter { length -> length < 5 }`.
        - ![](https://koenig-media.raywenderlich.com/uploads/2020/05/operators-650x366.png)
        - `zip(){}` Operator is used to make calls in parallel in `Flow`.
    - **Terminal Operators** Operators that start the flow by connecting the flow builder, operators with the collector.
      a `terminal` operator, you invoke all the intermediate operators along with it.
        - ![](https://koenig-media.raywenderlich.com/uploads/2020/05/flow-650x366.png)
        - `collect()` is the most basic terminal operator. It collects values from a `Flow` and executes an action with
          each item.

    - Use `catch()` to catch upstream exceptions that happens before it in the stream! this is called **exception
      transparency**, where you're able to separate the handling of exceptions that occur in the `Flow` form the
      collection of the values, you're being transparent about exceptions, as you don't hide any errors, you explicitly
      handle them in the operator!

    - Use `debounce(DELAY_MILLS)` operator to wait for values to stop arriving for a given time period, this is used to
      avoid sending too many requests.
    - Use `mapLatest()` to cancel the previous block if there is one, and make sure that the requested data is
      up-to-data.
    - `(1..5)reduce{ a, b -> a+ b} => [ 15]` is a terminal operator similar to `collect{}`

* **What is Context preservation in `Flow`?**
    - The collection of a `Flow` always happens in the context of the parent `Coroutine`
    - Use `onFlow()` to change the context of emissions when emitting items.
    - `Backpressure` is when the `Flow` produces events faster than the collector can consume them, this is
      a `Reactive stream` concept.

* **What is `ConflatedBroadcastChannel` in `Coroutines`?**
    - TODO()

* **What is `StateFlow`?**
    - `StateFlow` is like a way to use Kotlin `Flow` to manage and represent a state in an application.
    - For `x`, `y` where `x` is the value initially emitted and `y` is the value to be emitted, `StateFlow` makes sure,
      if `(x==y)` then do nothing but if `(x!=y)` then only emit the new value i.e. `y`
    - A regular `Flow` is cold but `StateFlow` is hot, which mean that the regular `Flow` does not have the concept of
      the last value, and it only becomes active when it gets collected, whereas `StateFlow`  has the concept of the
      last value, and it becomes active as soon as we create it.


* **What dose `out` and `in` means in `Kotlin`?**
    - `List<out T>` is like `List<? extends T>` in Java.
    - `List<in T>` is like `List<? super T>` in Java.
    - ex: ` val value : List<Any> = listOf(1,2,3)` since List signature is `List<out T>` in kotlin.
