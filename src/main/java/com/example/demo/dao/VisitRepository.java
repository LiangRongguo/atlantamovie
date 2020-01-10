package com.example.demo.dao;

import com.example.demo.po.visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VisitRepository extends JpaRepository<visit, Integer>, JpaSpecificationExecutor<visit> {
    Page<visit> findAll(Specification<visit> visitSpecification, Pageable pageable);
}
