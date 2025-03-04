package com.TaskTracker.rest.webservices.restful_web_services.helloWorld.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloworldController {
    
    @GetMapping("/helloworld")
    public String getHelloWorld() {
        return "HEllo welcome";
    }

    @GetMapping("/helloObj")
    public HelloWorld getHelloWorldObject() {
        return new HelloWorld("Hello World!");
        // throw new RuntimeException("Something went wrong, please contact the support *** 888!");
    }
    
    @GetMapping("/hello/{name}")
    public HelloWorld getHelloWorldPathParam(@PathVariable String name){
            // throw new RuntimeException("bruv ! try again I am cap");
        return new HelloWorld(String.format("Hello World, %s", name));
    }


}
