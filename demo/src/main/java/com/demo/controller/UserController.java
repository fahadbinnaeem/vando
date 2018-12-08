/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.dao.config.ConfigDao;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.util.admin.CustomAdminResponse;
import com.demo.config.ConfigHelper;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ahsan
 */
@RestController
@RequestMapping("/")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    ConfigDao configDao;
    
    @Autowired
    ConfigHelper configHelper;
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcom(){
        return "mayday mayday, demo got hit!!!!";
    }
    
     @RequestMapping(value = "/user", method = RequestMethod.POST)
    public CustomAdminResponse addUser(@RequestBody User u) {

//        u.setTime_stamp(new Timestamp(System.currentTimeMillis()));
        
            userService.insert(u);

            return new CustomAdminResponse(200, "OK", "User Created Successfully");

    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user",
            method = RequestMethod.GET, params = {"email"})
    public ResponseEntity<User> getUserByEmail(@RequestParam(value = "email") String email) {
        User u = userService.findUserByEmail(email);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    
        @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public CustomAdminResponse updateUser(@RequestBody User u) {
        if (u.getUser_id() < 1) {

            return new CustomAdminResponse(400, "BAD_REQUEST", "user_id not present");
        }
        userService.update(u);

        return new CustomAdminResponse(200, "OK", "User Updated Successfully");
    }
    
        @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public CustomAdminResponse deleteUser(@RequestBody User u) {
        userService.delete(u.getUser_id());

        return new CustomAdminResponse(200, "OK", "User Deleted Successfully");
    }
}
