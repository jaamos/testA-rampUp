package com.prealation.test.service;

import com.github.arteam.simplejsonrpc.core.annotation.JsonRpcMethod;
import com.github.arteam.simplejsonrpc.core.annotation.JsonRpcParam;
import com.github.arteam.simplejsonrpc.core.annotation.JsonRpcService;
import com.prealation.test.model.TDLCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonRpcService
public class Router {

    private static final Logger log = LogManager.getLogger(Router.class);

    TDLCategoryService categoryService = new TDLCategoryService();

    @JsonRpcMethod
    public boolean isAlive() {
        return true;
    }

    @JsonRpcMethod
    public void createCategory(@JsonRpcParam("name") String name, @JsonRpcParam("color") String color){
        categoryService.createCategory(name, color);
    }

    @JsonRpcMethod
    public TDLCategory createAndReturnCategory(@JsonRpcParam("name")  String name, @JsonRpcParam("color") String color){
        return categoryService.createAndReturnCategory(name, color);
    }
}
