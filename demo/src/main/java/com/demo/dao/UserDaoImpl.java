/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.dao.config.ConfigDao;
import com.demo.model.User;
import com.demo.config.ConfigHelper;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.core.io.DescriptiveResource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ahsan
 */
@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    DataSource ds;

    @Autowired
    ConfigDao configDao;

    @Autowired
    ConfigHelper configHelper;

    @PostConstruct
    public void initialize() {
        setDataSource(ds);
    }

    @Override
    public void insert(User u) {
        try {
            String sql = configDao.getConfigValue(configHelper.getValue(ConfigHelper.insert_user_key));
            getJdbcTemplate().update(sql, new Object[]{u.getUsername(),
                u.getEmail(),
                u.getPassword(),
                u.getAddress(),
                u.getContact(),
                u.getPhoneUuid()
            });
        } catch (DuplicateKeyException ex) {
            throw new IllegalArgumentException("Email already exists");
        }

    }

    @Override
    public void update(User u) {
        String sql = configDao.getConfigValue(configHelper.getValue(ConfigHelper.update_user_key));
        int updateRows = getJdbcTemplate().update(sql, new Object[]{
            u.getUsername(),
                u.getEmail(),
                u.getPassword(),
                u.getAddress(),
                u.getContact(),
                u.getPhoneUuid(),
                u.getUser_id()
        });
        
        if(updateRows < 1){
            throw new IllegalArgumentException("user does not exist with given id");
        }
    }

    @Override
    public void delete(int user_id) {
        String sql = configDao.getConfigValue(configHelper.getValue(ConfigHelper.delete_user_key));
        int updatedRows = getJdbcTemplate().update(sql, new Object[]{user_id});
        
        if(updatedRows < 1){
            throw new IllegalArgumentException("user does not exist with given id");
        }
    }

    @Override
    public User findUserByEmail(String email) {
        String sql = configDao.getConfigValue(configHelper.getValue(ConfigHelper.find_user_email_key));
        Object user = null;
        try {
            user = getJdbcTemplate().queryForObject(sql, new Object[]{email}, new UserRowMapper());
            System.out.println("");
        } catch (DataAccessException e) {
        }
        if (user == null) {
            throw new ResourceNotFoundException(email, new DescriptiveResource("email"));
        }
        return (User) user;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = configDao.getConfigValue(configHelper.getValue(ConfigHelper.find_all_user_key));
        List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
        return users;
    }

}
