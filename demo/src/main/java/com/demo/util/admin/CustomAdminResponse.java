/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.util.admin;

/**
 *
 * @author Ahsan
 */
public class CustomAdminResponse {
    
    int status;
    String description;
    String message;

    

    public CustomAdminResponse(int status, String description, String message) {
        this.status = status;
        this.description = description;
        this.message = message;
    }

    public CustomAdminResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
