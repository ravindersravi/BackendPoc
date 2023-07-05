package com.poc.paybylink.dao;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
//@AllArgsConstructor
@Entity(name = "UserLoginData")
public class UserLoginDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="emailId")
    private String emailId;

    @Column(name = "password")
    private String password;

}
