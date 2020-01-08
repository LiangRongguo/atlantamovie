package com.example.demo.service;

import com.example.demo.po.Company;
import com.example.demo.vo.CompanyQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Company saveCompany(String name);
    Company checkCompany(String name);
    void delete(String name);
    Page<Company> listCompany(Pageable pageable);

    Page<Company> filterCompany(Pageable pageable, CompanyQuery companyQuery);
}
