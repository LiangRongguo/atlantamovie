package com.example.demo.service;

import com.example.demo.dao.CreditcardRepository;
import com.example.demo.po.Creditcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreditcardServiceImpl implements CreditcardService {
    @Autowired
    private CreditcardRepository creditcardRepository;

    @Transactional
    @Override
    public Creditcard saveCreditcard(String creditcardnum, String username) {
        Creditcard creditcard = new Creditcard();
        creditcard.setCreditcardnum(creditcardnum);
        creditcard.setOwner(username);
        return creditcardRepository.saveAndFlush(creditcard);
    }

    @Override
    public Creditcard checkCreditcardnum(String creditcardnum) {
        Creditcard creditcard = creditcardRepository.findByCreditcardnum(creditcardnum);
        return creditcard;
    }

    @Transactional
    @Override
    public void delete(String creditcardnum) {
        creditcardRepository.deleteByCreditcardnum(creditcardnum);
    }

    @Override
    public int findNumberOfCreditcard(String username) {
        return creditcardRepository.findByOwner(username).size();
    }

}
