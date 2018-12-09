/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.config.ConfigHelper;
import com.demo.dao.config.ConfigDao;
import com.demo.model.Item;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ahsan
 */
@Repository
public class ItemDAOImpl extends JdbcDaoSupport implements ItemDAO {

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
    public void insertItem(ArrayList<Item> items) {
        for (Item item : items) {
            try {
                String sql = configDao.getConfigValue(configHelper.getValue(ConfigHelper.insert_item_key));
                getJdbcTemplate().update(sql, new Object[]{
                    item.getUserId(),
                    item.getDescription(),
                    item.getName(),
                    item.getCategory(),
                    item.getSubCategory(),
                    item.getManufacturingDate(),
                    item.getPhoto(),
                    item.getGeoLocatoin(),
                    item.getAddress(),
                    item.getQuatity(),
                    item.getContact()});
            } catch (DuplicateKeyException ex) {
                throw new IllegalArgumentException("Email already exists");
            }
        }
    }

    @Override
    public ArrayList<Item> getItemsByUserId(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Item> getItemsByRadius(String Latlng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
