/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.service;

import com.demo.model.User;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;

/**
 *
 * @author ahsan
 */
public interface UserService {
    
    void insert(User u)  throws DuplicateKeyException;

    void update(User u);

    void delete(int user_id);

    User findUserByEmail(String email);

    List<User> getAllUsers();
}
