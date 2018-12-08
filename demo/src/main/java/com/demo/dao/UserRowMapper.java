/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.model.User;
import com.demo.config.ConfigHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ahsan
 */
public class UserRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();
        
        u.setUser_id(rs.getInt(ConfigHelper.user_user_id));
        u.setEmail(rs.getString(ConfigHelper.user_email));
        u.setUsername(rs.getString(ConfigHelper.user_username));
        u.setContact(rs.getString(ConfigHelper.user_phone));
        u.setAddress(rs.getString(ConfigHelper.user_address));
        u.setPhoneUuid(rs.getString(ConfigHelper.user_phoneuuid));
//        u.setPassword(rs.getString(ConfigHelper.user_password));
        return u;
    }
    
}
