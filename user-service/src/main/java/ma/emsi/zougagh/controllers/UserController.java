package ma.emsi.zougagh.controllers;


import ma.emsi.zougagh.dtos.UserDto;
import ma.emsi.zougagh.services.IUserService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
//    private final Environment environment;
//    public UserController(Environment environment) {
//        this.environment = environment;
//    }
//    private final IUserService userService;
//    @GetMapping
//    public String getUser(){
//        return  "request served by instance " +environment.getProperty("server.port");
//    }
    private final IUserService userService;
    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
    @GetMapping
    public List<UserDto> selectUsers() {
        List<UserDto> l = Arrays.asList(new UserDto(1L,"hamsa","hamsa@emsil.com","aaaaa"));
        //TODO return userService.selectUsers();
        return l;
    }
}