package com.vamshi.ecommerce.controller;

import com.vamshi.ecommerce.entity.User;
import com.vamshi.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }
    @PostMapping("/login")
    public User login(@RequestBody Map<String,String>data){
        return userService.login(data.get("email"),data.get("password") );
    }
    @GetMapping
    public List<User>getAll(){
        return userService.getAllUser();
    }
}
