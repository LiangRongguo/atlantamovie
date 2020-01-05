package com.example.demo.service;

import com.example.demo.po.Admin;

public interface AdminService {
    Admin checkAdminExist(String username);
}
