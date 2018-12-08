/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.service;

import com.demo.dao.ItemDAO;
import com.demo.model.Item;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahsan
 */
@Service
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    ItemDAO itemDao;

    @Override
    public void insertItem(ArrayList<Item> item) {
        itemDao.insertItem(item);
    }

    @Override
    public ArrayList<Item> getItemsByUserId(String userId) {
        return itemDao.getItemsByUserId(userId);
    }
    
    @Override
    public ArrayList<Item> getItemsByRadius(String Latlng) {
        return itemDao.getItemsByRadius(Latlng);
    }

    @Override
    public void deleteItems() {
        itemDao.deleteItems();
    }
    
}
