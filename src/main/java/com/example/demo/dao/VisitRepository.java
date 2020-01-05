package com.example.demo.dao;

import com.example.demo.po.visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<visit, Integer> {
    Page<visit> findAll(Specification<visit> visitSpecification, Pageable pageable);
}
