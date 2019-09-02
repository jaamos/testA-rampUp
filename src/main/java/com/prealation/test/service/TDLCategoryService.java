package com.prealation.test.service;

import com.prealation.test.model.TDLCategory;
import com.prealation.test.model.TDLCategoryColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

public class TDLCategoryService extends DsService {

    private static final Logger log = LogManager.getLogger(TDLCategoryService.class);

    public TDLCategoryService() {
        super("categories");
    }

    public void createCategory(String name, String color){
        persistOne(createDocument(name, color));
    }

    public TDLCategory createAndReturnCategory(String name, String color){
        persistOne(createDocument(name, color));
        return new TDLCategory(name, TDLCategoryColor.byColor(color));
    }

    private Document createDocument(String name, String color){
        return new Document("type", "category").append("name", name).append("color", color);
    }

    //public TDLCategory findOneByColor(String color){

    //}
}