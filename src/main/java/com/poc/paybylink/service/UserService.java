package com.poc.paybylink.service;

import com.poc.paybylink.dao.UserDao;
import com.poc.paybylink.model.User;
import com.poc.paybylink.model.UserLogin;
import com.poc.paybylink.dao.UserLoginDao;
import com.poc.paybylink.repository.UserRegisterRepository;
import com.poc.paybylink.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRegisterRepository userRegisterRepository;
    public static final String FAILED_TO_SAVE_LOGIN_DETAILS = "Failed to Save Login details";
    public static final String SUCCESS = "Success";

    public String saveUserDetails(UserLogin userLogin) {
        if (userLogin != null) {
            UserLoginDao userLoginDao = new UserLoginDao();
            userLoginDao.setEmailId(userLogin.getEmail());
            userLoginDao.setPassword(userLogin.getPassword());
            userRepository.save(userLoginDao);
            return SUCCESS;
        }
        return FAILED_TO_SAVE_LOGIN_DETAILS;
    }

    public String registerUser(User user) {
        if (user != null) {
            UserDao userDao = new UserDao();
            userDao.setFirstName(user.getFirstName());
            userDao.setLastName(user.getLastName());
            userDao.setEmailId(user.getEmailId());
            userDao.setPanNumber(user.getPanNumber());
            userDao.setBankAccountNumber(user.getBankAccountNumber());

            userRegisterRepository.save(userDao);
            return SUCCESS;
        }
        return FAILED_TO_SAVE_LOGIN_DETAILS;
    }

}

