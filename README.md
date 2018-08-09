# Schedule App
This app will schedule some customs alarms for you and also will create a notification to remind you of your schedule. 

## Technical Approach

The development of this app is only in Koltin to explore the Kotlin library as well.

Also, this project will implement the dependency injection with dagger2 avoiding a lot of
boilerplates which the recent library update give to us. Usefull [Google sample.](https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/)

About the architecture I used clean with mvp approach and I used the rxKotlin to implement concurrency and abstract the data layer.
[Android Architecture references.](https://github.com/googlesamples/android-architecture)

The schedule data is only persisted locally and I use the Room to do that. If you don't meet Room yet, take a look [here](https://developer.android.com/topic/libraries/architecture/room).
