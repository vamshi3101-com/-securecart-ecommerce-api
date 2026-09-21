package com.vamshi.ecommerce.service;

import com.vamshi.ecommerce.entity.User;
import com.vamshi.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User register(User user){
        if(user.getRole()==null){
            user.setRole("USER");
        }
        return userRepository.save(user);
    }
    public List<User>getAllUser(){
        return userRepository.findAll();
    }
    public User login(String email,String password){
        return userRepository.findByEmail(email)
                .filter(u->u.getPassword().equals(password))
                .orElse(null);
    }
}
