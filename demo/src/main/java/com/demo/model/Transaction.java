/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

/**
 *
 * @author ahsan
 */
public class Transaction {
    
    private int transactionId;
    private String buyerUser;
    private String sellerUser;
    private String transactionDate;
    private boolean carHailingFlag;
    private String comments;
    private int itemId;

    public String getBuyerUser() {
        return buyerUser;
    }

    public void setBuyerUser(String buyerUser) {
        this.buyerUser = buyerUser;
    }

    public String getSellerUser() {
        return sellerUser;
    }

    public void setSellerUser(String sellerUser) {
        this.sellerUser = sellerUser;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isCarHailingFlag() {
        return carHailingFlag;
    }

    public void setCarHailingFlag(boolean carHailingFlag) {
        this.carHailingFlag = carHailingFlag;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
}
