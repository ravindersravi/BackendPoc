package com.poc.paybylink.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLogin {
    private String email;
    private String password;

}
