# README

## API & Web Automation Using Cucumber
API & Web UI Automation using Selenium Cucumber.

## Introduction
The purpose of this project is to demonstrate API & Web UI Automation using Selenium Cucumber.

## Installation
For installations, here are the steps:
1. Create an empty folder/directory in your computer
2. Open a terminal on a designated folder/directory
3. Clone the repository using `git clone https://github.com/arvyandwi/api-web-cucumber.git`

## Setup & Dependencies
This Project is currently using `selenium-java: 4.27.0`, `WebDriverManager: 5.9.2` (see [here](https://github.com/bonigarcia/webdrivermanager)), `cucumber-java: 7.20.1` and `junit-jupiter: 5.11.4` on `build.gradle` file. All dependencies are referenced [here](https://mvnrepository.com/).

## How To Run (API)
Click  The Run Button on a Feature File or in a runner Class such as `APITest.java`.

or

Terminal:
1. Open IntelliJ IDEA or any IDE(e.g. VSCode).
2. Type `./gradlew testApi`.

Terminal with `tags`:
1. Open IntelliJ IDEA or any IDE(e.g. VSCode).
2. Type `./gradlew tesApi -Ptags="tags"`. For instance, `./gradlew tesApi -Ptags=@validte-schema`

When Running the API Test, make sure you haven't created the same user. If you somewhat run only the `Create User` Scenario without deleting the user, you will get an error since the same user has already been created. Run the `Delete User` Scenario separately so you may reset the condition as it is.  

## How To Run (Web)
Click  The Run Button on a Feature File or in a runner Class such as `LoginTest.java`.

or

Terminal:
1. Open IntelliJ IDEA or any IDE(e.g. VSCode).
2. Type `./gradlew testWeb`.

Terminal with `tags`:
1. Open IntelliJ IDEA or any IDE(e.g. VSCode).
2. Type `./gradlew testWeb -Ptags="tags"`. For instance, `./gradlew tesApi -Ptags=@wrong-password`

## How To Run (API & Web)
Terminal:
1. Open IntelliJ IDEA or any IDE(e.g. VSCode).
2. Type `./gradlew runAuto`.

Terminal with `tags`:
1. Open IntelliJ IDEA or any IDE(e.g. VSCode).
2. Type `./gradlew testWeb -Ptags="tags"`. For instance, `./gradlew tesApi -Ptags=@api` to run only API Test or `./gradlew tesApi -Ptags=@web` to run only Web UI Test.

## Reports
Reports will be generated as HTML & JSON in `reports` folder that contains `test-report-api.html` and `test-report-api.json` for API, as well as `test-report-web.html` and `test-report-web.json` for Web.





