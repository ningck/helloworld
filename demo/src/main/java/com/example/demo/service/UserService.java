package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.prository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Page<User> findBookNoCriteria(Integer page, Integer size) {
        Pageable pageable =  PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return userRepository.findAll(pageable);

    }



    @Override
    public Page<User> findBookCriteria(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<User> bookPage = userRepository.findAll(new Specification<User>(){
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();

                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%"+"sa"+"%"));
                list.add(criteriaBuilder.like(root.get("password").as(String.class), "%"+"sd"+"%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);

        return bookPage;

    }
}
