/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author ahsan
 */
@Component
public class ConfigHelper {

    private final static String configPropertiesFileName = "config.properties";
    public static Properties configProperties;

    public static String app_server = "app_server";
    public static String delimiter = ",";
    public static String application_logging_state = "applicationStateKey";
    public static String permission_eval_sql = "permissionEvalSqlKey";
    
    //Config Mapper Column Name
    public static String config_id = "id";
    public static String config_key = "key";
    public static String config_scope = "scope";
    public static String config_description = "description";
    public static String config_value = "value";

    //User app config sql keys
    public static String insert_user_key = "insert_user_key";
    public static String update_user_key = "update_user_key";
    public static String delete_user_key = "delete_user_key";
    public static String find_user_email_key = "find_user_email_key";
    public static String find_all_user_key = "find_all_user_key";
    
    //User Mapper Column Name
    public static String user_user_id = "user_id";
    public static String user_username = "username";
    public static String user_email = "email";
    public static String user_password = "password";
    public static String user_is_enable = "is_enable";
    public static String user_time_stamp = "time_stamp";
    public static String user_company = "company";
    public static String user_phone = "contact";
    public static String user_address = "address";
    public static String user_designation = "designation";
    public static String user_purpose_of_usage = "purpose_of_usage";
    public static String activation_token = "activation_token";
    public static String activation_token_expiry = "activation_token_expiry";
    public static String user_phoneuuid = "phone_uuid";
    
    //item app config sql keys
    public static String insert_item_key = "insert_item_key";
    
    public static String user_insertion_success_msg = "User Added Successfully";
    public static String user_update_success_msg = "User Updated Successfully";
    public static String user_delete_success_msg = "User Deleted Successfully";
    
    public static String duplicate_key_message = "Duplicate Key Exception. Username or Email already exists.";
    public static String getConfigValueSql = "select id, key, scope, description, value  from ";
    
    public ConfigHelper() {
        if (configProperties != null) {
            return;
        }
        try {
            configProperties = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream(configPropertiesFileName);
            configProperties.load(in);
            IOUtils.closeQuietly(in);
        } catch (IOException ex) {
            Logger.getLogger(ConfigHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getValue(String key) {
        return configProperties.getProperty(key);
    }

    public String getConfigSql() {
        return getConfigValueSql;
    }
}
