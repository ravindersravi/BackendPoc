package com.poc.paybylink.controller;

import com.poc.paybylink.model.User;
import com.poc.paybylink.model.UserLogin;
import com.poc.paybylink.service.UserService;
import com.poc.paybylink.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "UserData", description = "PayByLink User management APIs")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Login with email and password", tags = { "UserLogin" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = UserLogin.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

    @PostMapping("/login")
    public String userLogin(@RequestBody UserLogin userLogin){
        return userService.saveUserDetails(userLogin);
    }

    @Operation(summary = "Register a new User", tags = { "New User Register" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = User.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "204", description = "There are no Tutorials", content = {
                    @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

}
