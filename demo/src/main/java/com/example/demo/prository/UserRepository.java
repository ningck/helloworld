package com.example.demo.prository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
    
    User findByName(String name);
}
