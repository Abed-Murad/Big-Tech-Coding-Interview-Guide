* **What is `ContentObserver`?**
    - `ContentObserer` is used to observe changes in a content provider.
    - Override `onChange(selfChange, uri)` to receive updates.
    - Pass a `Handle` in the `constructor`
        - If the `Handler` is created on the UI thread, `onChanged()` will be called on the UI thread.
        - If you passed `null`, android will call `onChanged()` immediately, regardless of the current thread used.
    - To register your `ContentObserver` just call the `ContentResolver.registerContentObserver()`
        - ```kotlin
            getContentResolver().registerContentObserver(SOME_URL, true, yourObserver)
          ```
    - The downside with `ContentObserver` is that you don't get any additional information about what has changed.


* **What is `IBinder` in services?**
    - `IBinder` an object that defines a programming interface that clients can use to interact with the service.


* **What is `Hilt`?**
    - `Hilt` is a dependency injection library build on top of `Dagger`.

* **How to use `Hilt`?**
    1. Add `@HiltAndroidApp` to the `Application` to serve as the application-level dependency container, this also will
       be the parent component of the app, which means all other components can access the dependencies that it
       provides.
    2. Add `AndroidEntryPoint` to your Android classes to tell `Hilt` to inject dependencies here.
    3. Add `@Inject` to preform field injection.
    4. `@Module` tells `Hilt` how to provide instances of certain types
    5. Use `@InstallIn` to tell `Hilt` which android class each module will be used or installed in.
    6. `@Bind` tells `Hilt` which implementation to use when it needs to provide an instance of an interface.
    7. `@Provides` tells `Hilt` how to generate an instance of a class that you don't own.
    