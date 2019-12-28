package com.example.demo.dao;

import com.example.demo.po.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    Manager findByStreetAndCityAndStateAndZipcode(String street, String city, String state, String zipcode);
}
