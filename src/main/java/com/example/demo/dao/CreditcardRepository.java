package com.example.demo.dao;

import com.example.demo.po.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditcardRepository extends JpaRepository<Creditcard, String> {
    Creditcard findByCreditcardnum(String creditcardnum);
    void deleteByCreditcardnum(String creditcardnum);
}
