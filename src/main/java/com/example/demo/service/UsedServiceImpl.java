package com.example.demo.service;

import com.example.demo.dao.UsedRepository;
import com.example.demo.po.Creditcard;
import com.example.demo.po.Used;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsedServiceImpl implements UsedService {
    @Autowired
    private UsedRepository usedRepository;

    @Override
    public Page<Used> filterUsed(Pageable pageable, String username) {
        return usedRepository.findAll(new Specification<Used>() {
            @Override
            public Predicate toPredicate(Root<Used> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Join<Used, Creditcard> joinUsed = root.join("creditcard", JoinType.LEFT);
                predicates.add(criteriaBuilder.equal(joinUsed.get("owner"), username));
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }
}
