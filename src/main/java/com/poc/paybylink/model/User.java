package com.poc.paybylink.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private  String firstName;
    private String lastName;
    private String emailId;
    private  String panNumber;
    private String bankAccountNumber;

}

