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
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserRegisterRepository userRegisterRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRegisterRepository userRegisterRepository) {
        this.userRepository = userRepository;
        this.userRegisterRepository = userRegisterRepository;
    }

    public static final String FAILED_TO_SAVE_LOGIN_DETAILS = "Failed to Save Login details";
    public static final String SUCCESS = "Success";

    public String saveUserDetails(UserLogin userLogin) {
        if (null != userLogin  && null != userLogin.getEmail()) {
            UserLoginDao userLoginDao = new UserLoginDao();
            userLoginDao.setEmailId(userLogin.getEmail());
            userLoginDao.setPassword(userLogin.getPassword());
            userRepository.save(userLoginDao);
            return SUCCESS;
        }
        return FAILED_TO_SAVE_LOGIN_DETAILS;
    }

    public String registerUser(User user) {
        if (null != user && null != user.getFirstName()) {
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

