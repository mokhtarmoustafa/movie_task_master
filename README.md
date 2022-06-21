# Movie Trends 

An android app built using [Jetpack](https://developer.android.com/jetpack) that consumes [Movies API](https://developers.themoviedb.org/3/getting-started/introduction) to display the Trends Movies .



---
# Setup Requirements
First, obtain your API key from  [Movies API](https://developers.themoviedb.org/3/getting-started/introduction).

---
# Tech Stack

- [MVVM Architecture](https://developer.android.com/topic/architecture) - A software architecture that removes the tight coupling between components. Most importantly, in this architecture, the children don't have the direct reference to the parent, they only have the reference by observables.
- [Hilt](https://dagger.dev/hilt/) - Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.
- [Jetpack Components](https://developer.android.com/jetpack)
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    - [Room](https://developer.android.com/training/data-storage/room) - Provides an abstraction layer over SQLite used for offline data caching.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
    - [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation) - Navigation is a framework for navigating between 'destinations' within an Android application that provides a consistent API whether destinations are implemented as Fragments, Activities, or other components.
- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client 
and supports coroutines out of the box.
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse 
requests on the data layer for Entities and understands Kotlin non-nullable 
and default parameters.
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [Flows](https://developer.android.com/kotlin/flow) - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.

---
# Screenshots
<img src="https://user-images.githubusercontent.com/22590747/174906145-d3b75f67-3348-4a19-863e-1604777af4e1.png" width="250" /> <img src="https://user-images.githubusercontent.com/22590747/174906128-0b6621cf-fe40-4f63-aeba-ea9ad2f56e72.png" width="250" /> 
---
> PRs are welcome :)
