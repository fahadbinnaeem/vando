/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao.config;

import com.demo.config.ConfigHelper;
import com.demo.model.config.Config;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammad Ali
 */
@Repository
public class ConfigDaoImpl extends JdbcDaoSupport implements ConfigDao{

    @Autowired
    DataSource ds;
    
    @Autowired
    ConfigHelper configHelper;
    
    @PostConstruct
    public void initialize(){
        setDataSource(ds);
    }
    
    @Override
    public String getConfigValue(String key) {
        String sql = ConfigHelper.getConfigValueSql + configHelper.getValue("appConfigTable") + " where " + configHelper.getValue("appConfigTableKey") + "=?";
        Object[] params = {key};
        Config configRow = (Config) getJdbcTemplate().queryForObject(sql, params, new ConfigRowMapper());
        return configRow.getValue();
    }
    
}
