package com.example.demo.service;

import com.example.demo.dao.CompanyRepository;
import com.example.demo.po.Company;
import com.example.demo.vo.CompanyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Page<Company> listCompany(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Page<Company> filterCompany(Pageable pageable, CompanyQuery companyQuery) {
        return companyRepository.findAll(new Specification<Company>() {
            @Override
            public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(companyQuery.getName())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("name"), companyQuery.getName()));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }
}
