# Joke-Telling

Created an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app will consist of four modules:

A Java library that provides jokes
A Google Cloud Endpoints (GCE) project that serves those jokes
An Android Library containing an activity for displaying jokes
An Android app that fetches jokes from the GCE module and passes them to the Android Library for display
Project contains a Java library for supplying jokes.
![alt tag](https://github.com/girish12ramesh/Joke-Telling/blob/master/joke.png)

# Features

Project contains an Android library with an activity that displays jokes passed to it as intent extras.

Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an AsyncTask.

Project contains connected tests to verify that the AsyncTask is indeed loading jokes.

Project contains paid/free flavors. The paid flavor has no ads and no unnecessary dependencies.

Ads are required in the free version.

Required Behavior
App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library. Note that the GCE module need only be deployed locally.
