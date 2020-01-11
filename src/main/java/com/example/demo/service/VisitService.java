package com.example.demo.service;

import com.example.demo.po.visit;
import com.example.demo.vo.VisitQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;

public interface VisitService {
    visit saveVisit(String date, String visitor, String theatername, String companyname);
    Page<visit> filterVisit(Pageable pageable, VisitQuery visit, HttpSession session);
}
