package com.example.demo.service;

import com.example.demo.po.User;
import com.example.demo.vo.UserQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User checkUser(String username, String password);
    User checkUserExist(String username);
    User saveUser(String username, String firstname, String lastname, String password);
    void delete(String username);

    Page<User> filterUser(Pageable pageable, UserQuery userQuery);
}
