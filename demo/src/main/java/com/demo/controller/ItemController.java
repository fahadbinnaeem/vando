/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.config.ConfigHelper;
import com.demo.dao.config.ConfigDao;
import com.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ahsan
 */
@RestController
@RequestMapping("/")
public class ItemController {
        
    @Autowired
    ItemService itemService;
    
    @Autowired
    ConfigDao configDao;
    
    @Autowired
    ConfigHelper configHelper;
}
