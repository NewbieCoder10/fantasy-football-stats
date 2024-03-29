###### Developed by: [Khasiano Webb](https://github.com/NewbieCoder10) 

###### Contact Information: 
[khasianow@yahoo.com](https://mail.yahoo.com/d/folders/1)
[LinkedIn Profile](https://www.linkedin.com/in/khasiano-webb/)

## [GitHub](https://newbiecoder10.github.io/fantasy-football-stats/)

## [Repository](https://github.com/NewbieCoder10/fantasy-football-stats)

## Introduction
An introduction to this app is that, it will allow users to
look up football information relating to players they are interested in.

## Description
Developed in Android, Football Info is a search app that will let users search up a player
they are interested in and return the information of that player. Also they will be able
to search for a team. Users can use their Google account to save searches they have looked up.
This will be possible because their account information will be remembered. 

The intended functionality will be a person on their mobile device using a search bar. This will
allow the user to search for the player or team they are interested in. 
My motivation for choosing this as a topic to work on is because it is something I can relate too.
I believe this is a potentially interesting app to users who like football, 
and want general information about their favorite players or teams. 

## Intended Users
Intended for users that may want information about a player
they are interested in looking up. Anyone who is interested in finding out
general information about their favorite players. Also, intended for users that
may want general information about their favorite team. This is intended 
for anyone who has an interest in football.

#### [User stories](docs/user-stories.md)

#### [Entity Relationship Diagram](docs/erd.md)

#### [Wireframe Diagram](docs/wireframe.md)


## Summary of current state of the app
* The current state of the completion of my app so far is it is fully functional; The
app runs and allows the user to use Google Sign-In to access the app. Also I have the
main-fragment that the user will be able to click on the team and it shows a list of 
players for that team. You can click on the player tab and print the information for that player.
So far, there are no bugs within my app.

#### Aesthetic/Cosmetic Improvements that I think would improve my app.
* Change the Main Color of the app, via settings.
* Change the Background-Color of the app, via settings.
* Change the font-type style of the app.

#### Stretch Goals
* I could possible work on the colors if I decide to change them.
* I could possible update the font height when needed/wanted.
* Changing the app to shift when the landscape of the phone is turned.

## Data Model Implementation
* [Implementation](docs/datamodelimplementation.md)

## Technical requirements & dependencies

#### Technical requirements
* I tested it on an API 21,
also with a Pixel 2 API 28 Emulator.

* The Minimum android API required is an API 21.

* It is in the Portrait restriction view.

* Android studio 3.4.1

* Pixel 2 API 28

* The Language restriction on this is English only.

#### Dependencies
 * Androidx 
    * appcompat
    * constraint-layout
    * lifecycle
    * room-runtime
    * legacy-support
    * room-compiler 
    * runner
    * espresso.espresso-core

* Google
    * android.material
    * android.gms:play-services-auth
    * code.gson

* Reactivex 
    * rxjava2:rxjava
    * rxjava2:rxandroid

* Squareup
    * retrofit2: retrofit
    * retrofit2: converter-gson
    * retrofit2: adapter
    * okhttp3: logging interceptor

* Facebook
    * stetho    

* Junit
    junit:4.12
    
### Third Party libraries.
implementation 'androidx.appcompat:appcompat:1.1.0'

    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'
    implementation 'androidx.preference:preference:1.1.0'
    implementation 'androidx.navigation:navigation-fragment:2.1.0'
    implementation 'androidx.navigation:navigation-ui:2.1.0'
    
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.google.android.gms:play-services-auth:17.0.0'

    implementation 'io.reactivex.rxjava2:rxjava:2.2.10'
    implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'


    def room_version = "2.2.1"
    implementation "androidx.room:room-runtime:$room_version"
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    annotationProcessor "androidx.room:room-compiler:$room_version"
    implementation 'com.google.code.gson:gson:2.8.6'

    def retrofit_version = "2.6.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"

    implementation 'com.squareup.okhttp3:logging-interceptor:3.14.2'

    implementation 'com.facebook.stetho:stetho:1.5.1'

    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.2.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'   
     


## External Services
[Draw.io](https://www.draw.io/)

[Google-Sign in](https://developers.google.com/identity/sign-in/android/start-integrating)
 
    
## Javadoc-generated technical documentation
[Javadoc](docs/api)


## Copyright & licenses

### Copyright
MIT License

Copyright (c) 2019 Khasiano 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.


### [License](https://github.com/NewbieCoder10/fantasy-football-stats/raw/master/LICENSE)


## Build Instructions
 * You will need to go to the repository site of this app, click the clone/download button
copy that link.

* Then with IntelliJ open, go to the IDE & click on checkout version control from Git, and click GitHub
repository, then paste your link into there. Then click cancel, cancel.

* Then click on the import button, from within the main page of IntelliJ, and click on the
project that you had just cloned & checked out from GitHub and it will open the project. 

* Build with gradle, and sync any changes from the Gradle.

* There should not be any errors when doing these steps to open the project, if there
are then you should Build, and Clean project, then rebuild the project. 

* Make sure the app is running onto a device with a minimum API 21.

* Finally sync all information for the Gradle build, and execute anything it ask you
to make sure the build is completed and finished correctly.


## Basic user instructions
* Once the User open's the app, there will be the Google Sign-in service, they will be prompted
to sign-in with their credentials.

* Once the User is in the app, they will then be on the main page of the app, it will
have a search-view and also a spinner-drop box they can use to search via the players, and 
teams.

* There will be a setting's icon located in the top right of the app, that will allow
the User to sign-out or go to the settings main-page. 

* Any user, that has experience when dealing with Android OS should be
able to access this fairly easy.


## First Milestone deliverable (Oct. 2nd)

* [x] Description

* [x] Intended Users & amp; user stories

* [x] Entity-relationship diagrams (ERD's)

* [x] Wireframes

## [Second Milestone deliverable (Oct. 28th](https://deep-dive-coding-java-cohort-8.github.io/2019/10/22/android-milestone-2-rubric.html)

* [x] Project description 

* [x] Intended users

* [x] User stories

* [x] Wireframes

* [X] ERD

* [x] Entity Classes

* [x] Dao interfaces

* [x] Database class

* [x] DDL

* [x] Chrome inspectability of data model


## [Third Milestone deliverable (Oct. 28th](https://deep-dive-coding-java-cohort-8.github.io/2019/11/12/android-standalone-project-rubric.html#overview)

* Documentation

* [x] Project introduction & description 

* [x] Intended users

* [x] User stories

* [x] Summary of current state of the app

* [x] Wireframe diagram

* [x] ERD

* [x] DDL

* [x] Technical requirements & dependencies 

* [x] Javadoc-generated technical documentation

* [x] Copyright and Licensing

* [x] Build Instructions

* [x] Basic User Instructions
