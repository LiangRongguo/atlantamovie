package com.example.demo.service;

import com.example.demo.po.Creditcard;

public interface CreditcardService {
    Creditcard saveCreditcard(String creditcardnum, String username);
    Creditcard checkCreditcardnum(String creditcardnum);
    void delete(String creditcardnum);
}
