package com.example.demo.service;

import com.example.demo.dao.AdminRepository;
import com.example.demo.po.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin checkAdminExist(String username) {
        return adminRepository.findByUsername(username);
    }
}
