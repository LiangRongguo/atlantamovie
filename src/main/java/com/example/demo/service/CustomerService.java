package com.example.demo.service;

import com.example.demo.po.Customer;

public interface CustomerService {
    Customer saveCustomer(String username);
    Customer checkCustomerExist(String username);
}
