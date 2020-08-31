# courier-tracking


[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Description 
Courier Tracking RESTful  API

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.X.X](https://maven.apache.org) (PS: If you do not have maven in your local.Spring is already initilazed to Maven Wrapper(spring.io))

## Setup

- Clone and open in Intellij Idea IDE
- Apache Lombok for IntelliJ IDEA
- Change database connection config in `src/main/resources/application.properties`(Optional)
- Install maven dependencies using IDE auto import or using the command ``mvn clean install``
- Run the app using for Spring Side ``mvn spring-boot:run`` or on Terminal for Jar files ``java -jar target/courier-tracking-0.0.1-SNAPSHOT.jar
``
- Browse the Swagger UI ``http://localhost:8080/swagger-ui.html``
- - Browse the H2 Database ``http://localhost:8080/h2``
  - Check the application.properties for h2 database config ``src/main/resource/application.properties``
  - To view your H2 in-memory database 
  - - The profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8080/h2 Default username is 'sa' with a blank password. Make sure you disable this in your production profiles.The Url Path is ``spring.datasource.url=jdbc:h2:mem:testdb``
                                                                                                                                                                                                                                  in addition to, The Driver Class Name is ``spring.datasource.driverClassName=org.h2.Driver``
                                                                                                                                                                                                                                  
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.migros.couriertracking.CourierTrackingApplication` class from your IDE.

First of all, you need to using the downloads plugin and you can use Maven Commands like so:

```
mvn clean install 
```

After than, you will be able to see success message on your console like so:

```
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ courier-tracking ---
[INFO] Installing /Users/arbade/Desktop/courier-tracking/target/courier-tracking-0.0.1-SNAPSHOT.jar to /Users/arbade/.m2/repository/com/migros/courier-tracking/0.0.1-SNAPSHOT/courier-tracking-0.0.1-SNAPSHOT.jar
[INFO] Installing /Users/arbade/Desktop/courier-tracking/pom.xml to /Users/arbade/.m2/repository/com/migros/courier-tracking/0.0.1-SNAPSHOT/courier-tracking-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  21.145 s
[INFO] Finished at: 2020-08-30T14:19:22+03:00
[INFO] ------------------------------------------------------------------------
```

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
After than you will be able to see that started message

```
2020-08-29 17:58:25.971  INFO 3798 --- [  restartedMain] c.m.c.CourierTrackingApplication         : Started CourierTrackingApplication in 2.772 seconds (JVM running for 3.471)

```

## RESTful API Methods

#### API Description for Project

| METHOD | PATH                       | DESCRIPTION              |
|--------|----------------------------|--------------------------|
| GET    | /api/v1/courier-locations  | Get All Courier Locations|
| GET    | /api/v1/courier-locations/total-distance/{courierId} | Get total distance of courier|
| POST   | /api/v1/courier-locations  | Create new Courier Location |

### Api Docs & Sample 

- Get All Courier Locations
```
GET /api/v1/tracks
```
- Content type ``json`` for ``http://localhost:8080/api/v1/courier-locations`` samples like so :
````
[
  {
    "id": 1,
    "courierId": 1,
    "timestamp": "2020-08-30T12:09:27.752",
    "lat": 22.34543,
    "lng": 49.22213
  },
  {
    "id": 2,
    "courierId": 1,
    "timestamp": "2020-08-30T12:10:43.214",
    "lat": 32.22212,
    "lng": 48.22109
  },
  {
    "id": 3,
    "courierId": 2,
    "timestamp": "2020-08-30T12:11:11.479",
    "lat": 25.22112,
    "lng": 47.00232
  }
]
````
- Also you will be able to see log message for courier like so:
```
c.m.c.c.CourierTrackingController        : Create CourierLocation request is started. CourierLocationDto: CourierLocationDto(id=0, courierId=1, timestamp=2020-08-31T20:55:09.609, lat=40.992332, lng=29.124422)
```

- Get total distance of courier
```
GET /api/v1/courier-locations/total-distance/{courierId}
```

- Create new  Courier Location
```
POST /api/v1/courier-locations
```

