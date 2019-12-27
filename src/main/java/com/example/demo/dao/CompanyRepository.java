package com.example.demo.dao;

import com.example.demo.po.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Company findByName(String name);
    void deleteByName(String name);
}
