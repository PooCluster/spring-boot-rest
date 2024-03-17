# Overview
This is a project so I can learn how to start a Spring Boot RESTful application from scratch with a couple simple endpoints:
- GET (read)
    - id 0 -> Hello, World!
    - id 1 -> Goodbye, World!
    - returns 404 if id is non-existent
    - returns 500 internal server error if id is null
- PUT (create and update)
    - (id, message)
    - returns 500 internal server error if id is null
- POST (create)
    - (id, message)
- DELETE (delete)
    - (id)

Each valid request should return 200.

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

### Preload JPA Database (Optional)
1. Look at springboot/src/main/java/com/poocluster/springboot/DatabaseConfig.java for following annotations and implementations of preloading database:
- `@Configuration`
- `@Bean`

### Implement REST functinality (controller)
1. Look at springboot/src/main/java/com/poocluster/springboot/HelloWorldController.java for following annotations and implementations of preloading databse:
- `@RestController`
- `@GetMapping()`
- `@PostMapping()`
- `@PutMapping()`
- `@DeleteMapping()`
- `@RequestBody`
- `@PathVariable`

### Hit the endpoints!
#### Via Curl
Before invoking any curl commands, run this one (curl is used by Invoke-WebRequest, which we don't need):
> `Remove-item alias:curl`

Get All:
> `curl -v http://localhost:8080/helloworlds`

Get by ID:
> `curl -v http://localhost:8080/helloworlds/{id}`

Post (create) new HelloWorld:
> `curl -v POST http://localhost:8080/helloworlds -H 'Content-Type:application/json' -d '{\"message\":\"Yuh\"}'`


Put (create/update) HelloWorld:
> `curl -v -X PUT http://localhost:8080/helloworlds/{id} -H 'Content-Type:application/json' -d '{\"message\":\"Wuh\"}'`

Delete HelloWorld by id:
> `curl -v -X DELETE http://localhost:8080/helloworlds/{id}`