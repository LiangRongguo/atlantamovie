package com.example.demo.dao;

import com.example.demo.po.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CreditcardRepository extends JpaRepository<Creditcard, String> , JpaSpecificationExecutor<Creditcard> {
    List<Creditcard> findByOwner(String username);
    Creditcard findByCreditcardnum(String creditcardnum);
    void deleteByCreditcardnum(String creditcardnum);
}
