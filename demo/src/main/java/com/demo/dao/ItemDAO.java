/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.model.Item;
import java.util.ArrayList;

/**
 *
 * @author ahsan
 */
public interface ItemDAO {
    
    public void insertItem(ArrayList<Item> item);
    
    public ArrayList<Item> getItemsByUserId(String userId);
    
    public ArrayList<Item> getItemsByRadius(String Latlng);
    
    public void deleteItems();
}
