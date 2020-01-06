package com.example.demo.dao;

import com.example.demo.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    void deleteByUsername(String username);

    Page<User> findAll(Specification<User> userSpecification, Pageable pageable);
}

