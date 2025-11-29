package ma.emsi.zougagh.controllers;


import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/users")
public class UserController {
    private final Environment environment;
    public UserController(Environment environment) {
        this.environment = environment;
    }
    @GetMapping
    public String getUser(){
        return  "request served by instance "
                +environment.getProperty("server.port");
    }
}