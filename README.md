# Overview
This is a project so I can learn how to start a Spring Boot RESTful application from scratch with a couple simple endpoints:
- GET
    - Hello World!
- PUT

## Steps
### Spring Boot Project Setup
1. Go to [Spring Initilizr](https://start.spring.io/)
2. Add following dependencies to project:
- Web: provides REST-related functions
- JPA: persists data in SQL storage
- H2: in-memory database
3. Fill out rest of information (trying out Gradle - Groovy, Java, Jar)
> - *[Group]* can be something like "com.poocluster"
> - *[Artifact]/[Name]* can be something like "springboot"; hypens ("-") disallowed

4. Click **GENERATE**; a *[Name]*.zip will download
5. Unzip the file and start it up in an IDE!
6. Set the SDK (ex. Java SDK 17)
> NOTE: ensure that IDE supports SDK
7. Test that the project is set up correctly:
- Right click `build.gradle` and click Run
- Open terminal in IDE, navigate to gradlew and run `./gradlew`

### Create a Payload and Storage
1. Look at springboot/src/main/java/com/poocluster/springboot/HelloWorld.java for following annotations and implementations of a payload:
- `@Entity`
- `@Id`
- `@GeneratedValue`
- `boolean equals(Object o)`
- `int hashCode()`
- `String toString()`
2. Look at springboot/src/main/java/com/poocluster/springboot/HelloWorldRepository.java for following implementation of a storage:
- `interface`
- `JpaRepository<Payload, Long>`