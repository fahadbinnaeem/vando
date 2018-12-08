/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao.config;

import com.demo.model.config.Config;
import com.demo.config.ConfigHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ahsan
 */
public class ConfigRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Config config = new Config();
        config.setId(rs.getInt(ConfigHelper.config_id));
        config.setKey(rs.getString(ConfigHelper.config_key));
        config.setDescription(rs.getString(ConfigHelper.config_description));
        config.setScope(rs.getString(ConfigHelper.config_scope));
        config.setValue(rs.getString(ConfigHelper.config_value));
        return config;
    }
    
}
