package com.example.demo.service;

import com.example.demo.po.visit;
import com.example.demo.vo.VisitQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;

public interface VisitService {
    Page<visit> filterVisit(Pageable pageable, VisitQuery visit, HttpSession session);
}
