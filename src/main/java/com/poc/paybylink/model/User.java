package com.poc.paybylink.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private  String firstName;
    private String lastName;
    private String emailId;
    private  String panNumber;
    private String bankAccountNumber;

}

