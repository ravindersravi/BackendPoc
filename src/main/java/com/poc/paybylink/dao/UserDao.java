package com.poc.paybylink.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@Entity(name = "userData")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="firstName")
    private  String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="emailId")
    private String emailId;

    @Column(name="panNumber")
    private  String panNumber;

    @Column(name="bankAccountNumber")
    private String bankAccountNumber;

}
