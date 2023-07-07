package com.poc.paybylink;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.paybylink.model.User;
import com.poc.paybylink.model.UserLogin;
import com.poc.paybylink.repository.UserRepository;
import com.poc.paybylink.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerITest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    public void createUserTest() throws Exception {
        User user = User.builder()
                .firstName("fname")
                .lastName("lname")
                .emailId("test@test.com")
                .panNumber("testpancard")
                .bankAccountNumber("23345")
                .build();

        String urlTemplate = "/api/v1/user/register";
        String expectedResult = "Success";
        expectedResponseData(user, urlTemplate, expectedResult);
    }

    @Test
    public void createUserFailedTest() throws Exception {
        User user = User.builder().build();

        String urlTemplate = "/api/v1/user/register";
        String expectedResult = "Failed to Save Login details";
        expectedResponseData(user, urlTemplate, expectedResult);
    }

    @Test
    public void createUserLoginTest() throws Exception {
        UserLogin userLogin = UserLogin.builder()
                .email("test@test.com")
                .password("1234abc").build();

        String urlTemplate = "/api/v1/user/login";
        String expectedResult = "Success";
        expectedResponseDataForLoggedInUser(userLogin, urlTemplate, expectedResult);
    }


    @Test
    public void userLoginFailed() throws Exception {
        UserLogin userLogin = UserLogin.builder().build();

        String urlTemplate = "/api/v1/user/login";
        String expectedResult = "Failed to Save Login details";
        expectedResponseDataForLoggedInUser(userLogin, urlTemplate, expectedResult);
    }

    private void expectedResponseDataForLoggedInUser(UserLogin user, String urlTemplate, String expectedResult) throws Exception {
        ResultActions response = mockMvc.perform(post(urlTemplate)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(user)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(expectedResult));
    }

    private void expectedResponseData(User user, String urlTemplate, String expectedResult) throws Exception {
        ResultActions response = mockMvc.perform(post(urlTemplate)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(user)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(expectedResult));
    }


}
