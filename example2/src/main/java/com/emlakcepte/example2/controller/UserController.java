package com.emlakcepte.example2.controller;


import com.emlakcepte.example2.models.User;
import com.emlakcepte.example2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/blog_users")
public class UserController {
    private final UserService m_userService;

    public UserController(UserService userService)
    {
        m_userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        m_userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<User> delete(@RequestBody User user) {
        m_userService.deleteUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get_user")
    public List<User> getAll()
    {
        return m_userService.getAllUser();
    }
    @GetMapping("/get_follower")
    public List<User> getAllFollower(@RequestBody User user)
    {
        return m_userService.getAllFollower(user);
    }


}

