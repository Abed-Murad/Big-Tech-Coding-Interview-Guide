# Android Technical Interview

## Contents

* [Core Android](#core-android)
* [Android Libraries](#android-libraries)
* [Android Architecture](#android-architecture)
* [Android Unit Testing](#android-unit-testing)
* [Android Tools And Technologies](#android-tools-and-technologies)
* [Java and Kotlin](#java-and-kotlin)

## Core Android

### Base

* **What is Android?**

    - An open source, Linux-based software stack for mobile devices
    - Includes Middlewares ex: Libraries, Dalvik VM...
    - Application Framework APIs ex: `LocationManger`, `PackageManger`, `ActivityManger`...
    - Key Application ex: Home Browser, Contacts, Phone...

* **What are the Android Application components?**

    - `Activities` A single screen with user interface, ex: List of emails, email details.
    - `Services` A component that runs in the background with no Interface ex: listening to music in while the device is
      locked.
    - `Broadcast receivers` A way to provide APIs to access data for multiple applications : User's contact info.
    - `Content providers` Allows sharing announcements.

* **Tell us about the Activity livecycle**
    - `onCreate()`
    - `onStart()` Called as long the device did not kill the activity
    - `onResume()` Activity is visible.
    - `onPause()` Another Activity is visible on top of this one.
    - `onStop()` Activity in the background.
    - `onDestroy()`

* **Tell us more about `Services`**
    - There are three ways of using `Service`:
        - Foreground: It must display a notification while operating in the background ex: music player.
        - Background: the user have no idea what's going on in the background ex: compressing an image file.
        - Bound: Here one or more components binds the `Service` using `bindService()`, it will be destroyed when the
          bound components unbind the service.
        - Started `startService()` runs indefinitely, usually for a single operation ex: upload a file.
        - Bound `bindService()` Bounded to the App ex: a Client-server interface.
    - A service can be started both ways `onStartComand()` & `onBind()`.

* **Tell us more about `Contents Providers`**
    - Data can be retrieved using `ContentResolver`.
        - returns a `Cursor` from after a query from `ContentResolver`
    - It stores data using SQLite or file storage.
    - Each Content Provider exposes a public URI ex: android.provider.Contacts.Phones.CONTENT_URI.

* **Tell us more about `Broadcast Receivers`.**
    - Usually Used to send Notifications to user ex: Toast Notification, Status Bar Notifications or Dialog
      Notifications.
    - Android broadcast an intent to all the activities, and they can receive it by registering BroadcastReceiver.

* **What is `AndroidManifest.xml` file?**
    - Each app must have this file in the root directory.
    - This file contains components description of the app ex: activities, services, permissions...

* **What is an `Intent`**
    - A messaging object used to request an action from another app component.
        - Explicit `Intent` to communicate with a particular component of the same application.
        - Implicit `Intent` to communicate between various applications in the device.
    - action: requested operation to perform ex: `ACTION_VIEW`, `ACTION_PICK`...
    - data: data to perform with, described as `URI`.
    - category: the intent belongs to which intent group.
    - type: MIME type to handle with.
    - extras: other customized application data.
    - `PendingIntent` used to ask someone to perform any Intent operation on behalf of you at the future.

* **What is an IntentFilter**
    - used to specify the type of components or actions that can be received by the application.
    - It can be defined in `AndroidManifest.xml` or `Activity.onResume()` with a BroadcastReceiver.


* **What is `Application` class?**
    - The `Application` is the based class within an Android.
    - It contains all other components ex: `activities`, `services`...
    - Instantiated before any other class in the app.


* **What is Context and how is it used?**
    - `Context` is the current state of the application
    - It's used to get information about the `Activity` & `Application`
    - It's used to access resources, databases, shared preferences...
    - Both 'Activity' & 'Application' extend the 'Context' class

* **What is `Fragment` ?**
    - `Fragment` is a sub-activity, a way to dynamically change the content of the screen without starting new Activity.
    - Used when some UI components are used across various activities or multiple views can be displayed side by a side
      ex: ViewPager.
    - It provides modularity & Adaptability
    - `Fragments` life-cycle is closely related to their host
        - `onAttatch()` Attached to the activity, pass the host `Activity` to the `Fragment`
        - `onCreate()` 'Fragment' instance initialization.
        - `onCreateView()` Draw 'Fragment' layout on screen
        - `onActivityCreated()` Activity completed its `onCreate()`
        - `onStart()` fragment is visible.
        - `onResume()` user can interact with the fragment
        - `onPause()` user can't interact with the fragment
        - `onStop()` fragment no longer visible
        - `onDestroyView()` view and related resources created in `onCreateView()` are removed and destroyed.
        - `onDestroy()` final clean up.
        - `onDetach()` fragment is detached from its host activity.

* **What are `LaunchMode` tag?**
    - `launchMode="singleTop"`
        - Creates & Adds Activity to the top of the stack if not already in the stack.
        - Sends the intent data to the Activity if it already created and on the top of the stack.
        - Creates new Activity if it's already in the stack but not in the top, sends the intent data to the new
          instance.
    - `launchMode="singleTask"`
        - destroy all activities above of the activity in the stack if it was already created, sends new Intent data to
          it.
    - `launchMode="singleInstance"`
        - Creates a new task for the activity.
    - `launchMode="standard"`
        - Creates a new Instance if not on top, sends intent data if already on top of the stack.


* **Tell us about Fragment Communication**
    - Fragments should not communicate directly between each others.
    - Communications can be done in two ways:
        - With the help of `ViewModel`: a shared `ViewModel` between all the fragments
        - With the help of `Interface`

* **What is `View` & `ViewGroup`?**
    - `View` is the superclass of all the UI components ex: `TextView`, `EditText`, `DatePicker`...
    - `View` is a Rectangular area which is going to contain some element inside it.
    - `ViewGroup` is an invisible container that holds other `Views` and 'ViewGroups' inside it.

* **Tell us about the different layouts in android.**
    - `RelativeLayout` The elements arranged concerning each others.
    - `LinearLayout` The elements arranged in a line, either `horizontal` or `vertical`.
    - `FrameLayout` Used for complex designs where components are on top of each others
    - `ConstraintLayout` All above, responsive UI that adapt automatically to different screen sizes.

* **Tell us about what a RecyclerView.**
    - A `ViewGroup` that populates a list of views based on the provided Collection fod data, with the help of '
      ViewHolder' and draws it to the user on screen.
    - It has three major components
        - `Adapter` subtype of `RecyclerView.Adapter` that binds the data to the corresponding views.
            - `onCreateViewHolder(parent, viewType)`
            - `onBindViewHolder(holder, position)`
            - `getItemCount()`
            - `getViewType(postion)`
        - `ViewHolder` subtype of `RecyclerView.ViewHolder` Helper class that help to draw the UI for individual items
          that we want to draw on screen
        - `LayoutManger` Helps with the way we want the items to be displayed (Linearly or in a Grid). 
    