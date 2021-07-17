package com.vn.paysmart.dbconnector.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DBConfig {
    public static Gson gson = new Gson();
    public static Logger LOGGER = LoggerFactory.getLogger(DBConfig.class);
    public static Map<String, Map<String, String>> config = new HashMap<>();
    public static JsonObject lstServer = new JsonObject();

    public void reloadConfig() {
        try (Reader reader = Files.newBufferedReader(Paths.get("conf/config.json"));
             Reader readerLstServer = Files.newBufferedReader(Paths.get("conf/server_list.json"))) {
            config = gson.fromJson(reader, Map.class);
            lstServer = gson.fromJson(readerLstServer, JsonObject.class);

        } catch (IOException e) {
            LOGGER.error("Get configuration ex : {}", e.getMessage());
        }
        System.out.println(config);
    }

    @Bean
    public void initConfig() {
        try (Reader reader = Files.newBufferedReader(Paths.get("conf/db.json"))) {
            config = gson.fromJson(reader, Map.class);
        } catch (IOException e) {
            LOGGER.error("Get configuration ex : {}", e.getMessage());
        }
    }
}
