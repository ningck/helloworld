package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")

//@Data使用后，可以减少set/get的编写，在使用的时候直接引用
@Data
public class User {

    //设置id为主键，同时设置为自增长的类型
    @Id@GeneratedValue
    private int id;

    private String name;
    private String password;
}
