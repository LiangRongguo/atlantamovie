package com.example.demo.dao;

import com.example.demo.po.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Company findByName(String name);
    void deleteByName(String name);
    Page<Company> findAll(Specification<Company> companySpecification, Pageable pageable);

}
