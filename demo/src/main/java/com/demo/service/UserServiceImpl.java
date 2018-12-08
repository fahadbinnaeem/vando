/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.model.User;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahsan
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao; 
    
    @Override
    public void insert(User u)  throws DuplicateKeyException{
        userDao.insert(u);
    }

    @Override
    public void update(User u) {
        userDao.update(u);
    }

    @Override
    public void delete(int user_id) {
        userDao.delete(user_id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
