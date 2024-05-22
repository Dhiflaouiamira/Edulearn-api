package com.tekup.EduLearnapi.controller;

import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> findAllUsers() {
        return userServices.findAll();
    }

    @GetMapping("/{id}")
    public User findOneUser(@PathVariable long id) {
        return userServices.findOne(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userServices.AddOne(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userServices.DeleteOne(id);
    }
}
