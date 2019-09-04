package com.prealation.test.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import com.prealation.test.ds.Configuration;
import com.prealation.test.ds.DbProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import java.util.List;

public class DsService {

    private static final Logger log = LogManager.getLogger(DsService.class);

    MongoCollection<Document> collectionField;
    MongoDatabase mongoDatabase;

    public DsService(String collectionName) {
        if (Boolean.valueOf(Configuration.config().getProperty("enable.db"))) {
            mongoDatabase = DbProvider.connection();
            collectionField = mongoDatabase.getCollection(collectionName);
        }
    }

    public MongoCollection<Document> collection(){
        return collectionField;
    }

    public void persistOne(Document document){
        if (Boolean.valueOf(Configuration.config().getProperty("enable.db"))) {
            collection().insertOne(document);
        }
    }

    public void persistMany(List<Document> documents){
        if (Boolean.valueOf(Configuration.config().getProperty("enable.db"))) {
            collection().insertMany(documents, new InsertManyOptions().ordered(false));
        }
    }
}