package com.example.demo.service;

import com.example.demo.po.Manager;

public interface ManagerService {
    Manager checkManagerExist(String username);
    Manager checkStreetAddress(String street, String city, String state, String zipcode);
    Manager saveManager(String username, String company, String street, String city, String state, String zipcode);
}
