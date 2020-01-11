package com.example.demo.service;

import com.example.demo.dao.VisitRepository;
import com.example.demo.po.User;
import com.example.demo.po.visit;
import com.example.demo.vo.VisitQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitRepository visitRepository;

    @Override
    public Page<visit> filterVisit(Pageable pageable, VisitQuery visit, HttpSession session) {
        return visitRepository.findAll(new Specification<visit>(){
            @Override
            public Predicate toPredicate(Root<visit> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                User user = (User) session.getAttribute("user");
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(user.getUsername())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("visitor"), user.getUsername()));
                }
                if (!"".equals(visit.getCompany())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("companyname"), visit.getCompany()));
                }
                if (!"".equals(visit.getBeginDate())) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<String>get("date").as(String.class), visit.getBeginDate()));
                }
                if (!"".equals(visit.getEndDate())) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<String>get("date").as(String.class), visit.getEndDate()));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public visit saveVisit(String date, String visitor, String theatername, String companyname) {
        visit v = new visit(date, visitor, theatername, companyname);
        return visitRepository.saveAndFlush(v);
    }
}
