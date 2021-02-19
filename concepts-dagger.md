# Dagger * DI

* **What is `@Provides`**?
    - The returned objects from methods annotated with `@Provides` are available for Dependency injection.
    - `@Provides` can be found inside `@Module` classes, which are responsible for providing objects which can be
      injected.