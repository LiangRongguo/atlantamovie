package com.example.demo.service;

import com.example.demo.dao.TheaterRepository;
import com.example.demo.po.Theater;
import com.example.demo.vo.TheaterQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public Page<Theater> listTheater(Pageable pageable) {
        return theaterRepository.findAll(pageable);
    }

    @Override
    public Page<Theater> filterTheater(Pageable pageable, TheaterQuery theater) {
        return theaterRepository.findAll(new Specification<Theater>() {
            @Override
            public Predicate toPredicate(Root<Theater> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(theater.getTheater())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("theatername"), theater.getTheater()));
                }
                if (!"".equals(theater.getCompany())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("companyname"), theater.getCompany()));
                }
                if (!"".equals(theater.getCity())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("city"), theater.getCity()));
                }
                if (!"".equals(theater.getState())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("state"), theater.getState()));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }
}

