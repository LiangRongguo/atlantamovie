package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.po.User;
import com.example.demo.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public User checkUserExist(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Transactional
    @Override
    public User saveUser(String username, String firstname, String lastname, String password) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setPassword(MD5Utils.code(password));
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    @Override
    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }
}
