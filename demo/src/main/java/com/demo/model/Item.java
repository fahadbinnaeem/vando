/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.vividsolutions.jts.geom.Point;

/**
 *
 * @author ahsan
 */
public class Item {
    
    private int itemId;
    private String name;
    private String description;
    private String category;
    private String subCategory;
    private String manufacturingDate;
    private String photo;
    private String address;
    private String quatity;
    private String contact;
    private String geoLocatoin;

    public String getGeoLocatoin() {
        return geoLocatoin;
    }

    public void setGeoLocatoin(String geoLocatoin) {
        this.geoLocatoin = geoLocatoin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    private int userId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
