package com.example.demo.dao;

import com.example.demo.po.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByUsername(String username);
    void deleteByUsername(String username);
}
