package com.prealation.test.ds;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class DbProvider {

    private static final Logger log = LogManager.getLogger(DbProvider.class);

    static MongoClient mongoClient;
    static MongoDatabase database;

    static {
        mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(
                                        new ServerAddress(Configuration.config().get("db.host").toString(), Integer.valueOf(Configuration.config().get("db.port").toString()))
                                )))
                        .build());

        database = mongoClient.getDatabase(Configuration.config().get("db.database").toString());
        log.info("database: " + database);
    }

    public static MongoDatabase connection() {
        return database;
    }

    public static void close() {
        if (mongoClient == null) return;
        mongoClient.close();
        log.info("Mongo Client closed!");
    }
}