package com.example.demo.service;

import com.example.demo.dao.ManagerRepository;
import com.example.demo.po.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager checkManagerExist(String username) {
        return managerRepository.findByUsername(username);
    }

    @Override
    public Manager checkStreetAddress(String street, String city, String state, String zipcode) {
        return managerRepository.findByStreetAndCityAndStateAndZipcode(street, city, state, zipcode);
    }

    @Override
    public Manager saveManager(String username, String company, String street, String city, String state, String zipcode) {
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setWorks_in(company);
        manager.setStreet(street);
        manager.setCity(city);
        manager.setState(state);
        manager.setZipcode(zipcode);
        return managerRepository.saveAndFlush(manager);
    }
}
