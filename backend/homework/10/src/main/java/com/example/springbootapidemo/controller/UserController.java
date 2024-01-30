package com.example.springbootapidemo.controller;

import com.example.springbootapidemo.exception.custom.MyCustomException;
import com.example.springbootapidemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    List<User> userList = new ArrayList<>();

    // POST : /user
    // {name: "abc", age: 12}
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        logger.error("Adding a new user to memory");
        userList.add(user);
//        throw new ArrayStoreException("Array store issue.");
        return ResponseEntity.ok("User Added successfully!");
    }

    // GET : /user/2
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        User user = null;
        try{
            user = userList.get(id);
        }catch(IndexOutOfBoundsException ex){
            throw new MyCustomException("No data of id - " + id + "in storage");
        }
        return userList.get(id);
    }

    // GET : /search/user?name=Rishav

    @GetMapping("/search/user")
    public User searchUser(@RequestParam String name){
        logger.info("searching user");
        User temp = null;
        for (User user: userList){
            if (user.getName().equals(name)){
                temp = user;
            }
        }
        return temp;
    }

    @GetMapping("/user/getlist")
    public String getAllUsersList(){
        logger.info("The user list is getting accessed");
        String ans = "";
        for(User user : userList){
            ans +=user.getName() +",";
        }
        return ans;
    }

    // PUT: /user/1
    // {name: "abc", age: 12}

    // DELETE: /user/1
}
