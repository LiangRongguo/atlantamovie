package com.example.demo.service;

import com.example.demo.dao.CompanyRepository;
import com.example.demo.po.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    @Override
    public Company saveCompany(String name) {
        Company company = new Company();
        company.setName(name);
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public Company checkCompany(String name) {
        Company company = companyRepository.findByName(name);
        return company;
    }

    @Transactional
    @Override
    public void delete(String name) {
        companyRepository.deleteByName(name);
    }

    @Transactional
    @Override
    public Page<Company> listCompany(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }
}
