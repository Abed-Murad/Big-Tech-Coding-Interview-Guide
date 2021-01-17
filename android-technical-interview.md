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
    - `onStart()`
    - `onResume()` Activity is visible.
    - `onPause()` Another Activity is visible on top of this one.
    - `onStop()` Activity in the background.
    - `onDestroy()`

* **Tell us more about `Services`**
    - A service can take two forms:
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
    - An Object that holds the content of a massage.
    - action: requested operation to perform ex: `ACTION_VIEW`, `ACTION_PICK`...
    - data: data to perform with, described as `URI`.
    - category: the intent belongs to which intent group.
    - type: MIME type to handle with.
    - extras: other customized application data.

* **What is an IntentFilter**
    - Match activities in the application against an intent
    - It can be defined in `AndroidManifest.xml` or `Activity.onResume()` with a BroadcastReceiver.
  