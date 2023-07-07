package com.poc.paybylink.service;

import com.poc.paybylink.model.User;
import com.poc.paybylink.model.UserLogin;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public String registerUser(User user);
    public String saveUserDetails(UserLogin userLogin) ;
}

