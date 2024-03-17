package com.poocluster.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // performs CRUD actions for HelloWorldRepository on HelloWorld objects
public class HelloWorldController {

    private final HelloWorldRepository helloWorldRepository;

    HelloWorldController(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    // gets all HelloWorlds in HelloWorldRepository
    @GetMapping("/helloworlds")
    List<HelloWorld> all() {
        return helloWorldRepository.findAll();
    }

    // create HelloWorld
    @PostMapping("/helloworlds")
    HelloWorld newHelloWorld(@RequestBody HelloWorld helloWorld) {
        return helloWorldRepository.save(helloWorld);
    }

    // get HelloWorld
    @GetMapping("/helloworlds/{id}")
    HelloWorld getHelloWorld(@PathVariable Long id) {
        return helloWorldRepository.findById(id).orElseThrow(
            () -> new RuntimeException("HelloWorld " + id + " does not exist.")
        );
    }

    // update HelloWorld
    @PutMapping("/helloworlds/{id}")
    HelloWorld updateHelloWorld(@RequestBody HelloWorld updatedHelloWorld, @PathVariable Long id) {
        return helloWorldRepository.findById(id).map(
            // updates existing HelloWorld
            helloWorld -> {
                helloWorld.setMessage(updatedHelloWorld.getMessage());
                helloWorld.setId(id);
                return helloWorldRepository.save(helloWorld);
            }
        ).orElseGet(
            // creates new HelloWorld if non-existent
            () -> {
                updatedHelloWorld.setId(id);
                return helloWorldRepository.save(updatedHelloWorld);
            }
        );
    }

    @DeleteMapping("/helloworlds/{id}")
    void deleteHelloWorld(@PathVariable Long id) {
        helloWorldRepository.deleteById(id);
    }

}
