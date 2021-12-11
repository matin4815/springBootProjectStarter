package com.clarity.springbootproject.controller;


import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/json")
    public String json(){
        List<User> users = new ArrayList<>();
        User user = new User("username", "password");
        User user2 = new User("user", "1234");
        users.add(user);
        users.add(user2);
        return new Gson().toJson(users);
    }


    @RequestMapping(value = {"/path/{username}/{password}", "/path/{password}"}, method = RequestMethod.POST)
    public String path(@PathVariable(value = "username", required = false) String username, @PathVariable(value = "password") String password){
        return "Hello " + username+ " , " + password;
    }

    @RequestMapping(value = "/query-param")
    public String userNameQueryParam(@RequestParam(value = "name") String userName, @RequestParam(value = "password") String password){
        return "Hello" + userName + ", " + password;
    }

    @RequestMapping(value = "/body")
    public String body(@RequestBody User body){
        return body.getUsername() + " , " + body.getPassword();
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String userName(){
        return "user name";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userNameGet(){
        return "user name";
    }


    @GetMapping(value = "/{name}")
    public String userNamePathVariable(@PathVariable(value = "name") String name){
        return name;
    }

    @PostMapping(value = "/post")
    public String postRequest(){
        return "post request";
    }

    @GetMapping(value = "/get")
    public String getRequest(){
        return "get request";
    }



}
