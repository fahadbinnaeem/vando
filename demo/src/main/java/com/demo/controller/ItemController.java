/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.config.ConfigHelper;
import com.demo.dao.config.ConfigDao;
import com.demo.model.Item;
import com.demo.model.User;
import com.demo.service.ItemService;
import com.demo.util.admin.CustomAdminResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author ahsan
 */
@RestController
@RequestMapping("/")
public class ItemController {// 

    @Autowired
    ItemService itemService;

    @Autowired
    ConfigDao configDao;

    @Autowired
    ConfigHelper configHelper;

    private Path fileStorageLocation;

    @RequestMapping(value = "/item")
    public CustomAdminResponse addItems(@RequestParam Map<String, String> requestParams, MultipartHttpServletRequest multiRequest, @RequestHeader(value = "X-Lang", required = false) String xlang) throws IOException {
        System.out.println("aasd");
//        u.setTime_stamp(new Timestamp(System.currentTimeMillis()));
        String fileName = "";
        if (multiRequest != null) {
            Map<String, MultipartFile> files = multiRequest.getFileMap();
            for (String key : files.keySet()) {
                MultipartFile file = multiRequest.getFile(key);
                fileName = StringUtils.cleanPath(file.getName());
                fileStorageLocation = Paths.get("/tmp/")
                        .toAbsolutePath().normalize();
                Path targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            }

        }

        Item item = new Item();
        item.setName(requestParams.get("name"));
        item.setUserId(Integer.parseInt(requestParams.get("userid")));
        item.setAddress(requestParams.get("address"));
        item.setCategory(requestParams.get("category"));
        item.setContact(requestParams.get("contact"));
        item.setDescription(requestParams.get("description"));
        item.setGeoLocatoin(requestParams.get("geolocation"));
        item.setManufacturingDate(requestParams.get("manufacturingdate"));
        item.setPhoto("/tmp/" + fileName);
        item.setQuatity(requestParams.get("quantity"));
//        item.setSubCategory(requestParams.get("subcategory"));
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);
        itemService.insertItem(items);
        return new CustomAdminResponse(200, "OK", "User Created Successfully");

    }
}
