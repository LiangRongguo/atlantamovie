package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.po.User;
import com.example.demo.util.MD5Utils;
import com.example.demo.vo.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public User checkUserExist(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Transactional
    @Override
    public User saveUser(String username, String firstname, String lastname, String password) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setPassword(MD5Utils.code(password));
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    @Override
    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public Page<User> filterUser(Pageable pageable, UserQuery userQuery) {
        return userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(userQuery.getUsername())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("username"), userQuery.getUsername()));
                }
                if (!"".equals(userQuery.getStatus())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("status"), userQuery.getStatus()));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }
}
