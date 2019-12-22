package com.example.demo.service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.po.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public Customer saveCustomer(String username) {
        Customer customer = new Customer();
        customer.setUsername(username);
        // User u = userRepository.findByUsername(username);
        // customer.setUser(u);
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer checkCustomerExist(String username) {
        Customer customer = customerRepository.findByUsername(username);
        return customer;
    }
}
