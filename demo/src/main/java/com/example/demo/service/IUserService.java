package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

public interface IUserService {

    User findUserByName(String name);

    Page<User> findBookNoCriteria(Integer page, Integer size);
    Page<User> findBookCriteria(Integer page,Integer size);

}
