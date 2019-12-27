package com.example.demo.service;

import com.example.demo.po.Company;

public interface CompanyService {
    Company saveCompany(String name);
    Company checkCompany(String name);
    void delete(String name);
}
