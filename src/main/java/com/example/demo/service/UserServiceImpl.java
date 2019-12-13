package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        System.out.println(username);
        User user = userRepository.findByUsernameAndPassword(username, password);
        //User user = userRepository.findByUsername(username);
        System.out.println(user.toString());
        return user;
    }
}
