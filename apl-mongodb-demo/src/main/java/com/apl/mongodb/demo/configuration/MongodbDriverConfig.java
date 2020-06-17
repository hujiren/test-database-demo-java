package com.apl.mongodb.demo.configuration;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
/**
 * @author hjr start
 * @date 2020/6/5 - 17:29
 */

public class MongodbDriverConfig {

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    private static final String COLON = ":";

    private static final String DOUBLE_SLASH = "//";




}
