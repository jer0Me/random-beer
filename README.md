# Random Beer Technical test

This project was created mainly for a technical test.

Simple web app that displays details about a random beer.

The functionality should allow a user to click on the ‘Show Another Beer’ button to view information about the next random beer.


## Stack:

### REST API

* Spring Boot
* Spring Data Jpa
* FlywayDB
* Lombok
* H2
* Mockito

### Client

* Angular 7
* Bootstrap 4


## How to test the web application:

### REST API

To be able to run the REST API you need:

* Gradle
* JDK 8

Once you have all above installed, just go to the folder *restapi* and execute:

```
./gradlew bootRun
```
After executing the previous command, the REST API will be up and listening to the port 8080

### Angular

For the angular application you just need Node installed in your machine. After that, go to the folder *client* and execute:

```
npm install && npm start
```

From here, everything should be ready. Just navigate to the url http://localhost:4200 to test the web application.
