package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(String username) {
        Employee employee = new Employee();
        employee.setUsername(username);
        return employeeRepository.saveAndFlush(employee);
    }
}
