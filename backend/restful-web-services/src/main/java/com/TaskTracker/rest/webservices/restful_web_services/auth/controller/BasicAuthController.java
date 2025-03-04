package com.TaskTracker.rest.webservices.restful_web_services.auth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class BasicAuthController {

    @GetMapping("/basicAuth")
    public AuthenticationBean authBean(){
            return new AuthenticationBean("You are authenticated!");
    }
    
}
