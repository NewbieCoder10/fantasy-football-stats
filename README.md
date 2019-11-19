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
* The current state of the completion of my app so far is that it runs and allows the
user to use Google Sign-In to access the app. Also I have the main-fragment that the user
will be able to click on the team or player tab and print the information of the team
or the player. I need to make sure that the app is able to communicate with the 
information that the user is entering. As it is known so far, there are no bugs within my app. 


* I could possible work on the colors if I decide to change them, although I do like the
current color of the app up to this point. I could try to update the font possibly if I can
figure out what to do within my app.


* I might try to create more things that are more fragments if needed within
my project.
 
 
* I would be able to create more within the database, if I could and also
had the free API resources to do so.


## Data Model Implementation
* [Implementation](docs/datamodelimplementation.md)

## Technical requirements & dependencies

#### Technical requirements
* I tested it on an API 21,
also with a Pixel 2 API 28 Emulator.

* The Minimum android API required is an API 21.

* It is in the Portrait restriction view.

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
     
## Javadoc-generated technical documentation
[Javadoc-generated](file:///C:/Users/Khasiano/Desktop/bootcamp/projects/fantasy-football-stats/docs/api/index.html)





## Copyright & licenses






## Build Instructions
 * You will need to go to the repository site of this app, click the clone/download button
copy that link.

* Then with IntelliJ open, click on checkout version control from Git, and click GitHub
repository, then paste your link into there. Then click cancel, cancel.

* Then click on the open button, from within the main page of IntelliJ, and click on the
project that you had just cloned & checked out from GitHub. 

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

* [ ] Javadoc-generated technical documentation

* [ ] Copyright and Licensing

* [x] Build Instructions

* [x] Basic User Instructions
