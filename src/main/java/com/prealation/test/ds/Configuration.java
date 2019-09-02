package com.prealation.test.ds;

import com.github.arteam.simplejsonrpc.server.JsonRpcServer;
import com.google.common.cache.CacheBuilderSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Logger log = LogManager.getLogger(Configuration.class);

    static Properties configuration = new Properties();
    static JsonRpcServer jsonRpcServer;

    static {
        jsonRpcServer = JsonRpcServer.withCacheSpec(CacheBuilderSpec.disableCaching());
        try {
            try (InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("dbConfig.properties")) {
                configuration.load(inputStream);
            }
        } catch (IOException ex) {
            log.error("Properties loading error! : ", ex);
        }
    }

    public static Properties config() {
        return configuration;
    }

    public static JsonRpcServer server() {
        return jsonRpcServer;
    }
}