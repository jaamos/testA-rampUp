package com.prealation.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class TotoList {

    @JsonProperty
    String title;

    @JsonProperty
    List<TDLItems> items = new ArrayList<>();

    @JsonProperty
    TDLCategory category;


    @JsonCreator
    public TotoList(@JsonProperty("title") String title, @JsonProperty("category") TDLCategory category) {
        this.title = title;
        this.category = category;
    }

    @JsonCreator
    public TotoList(@JsonProperty("title") String title, @JsonProperty("items") List<TDLItems> items, @JsonProperty("category") TDLCategory category) {
        this.title = title;
        this.items = items;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TDLItems> getItems() {
        return items;
    }

    public void setItems(List<TDLItems> items) {
        this.items = items;
    }

    public boolean addItem(TDLItems item){
        return items.add(item);
    }

    public boolean removeItem(TDLItems item){
        return items.remove(item);
    }

    public TDLCategory getCategory() {
        return category;
    }

    public void setCategory(TDLCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "TotoList{" +
                "title='" + title + '\'' +
                ", items=" + items +
                ", category=" + category +
                '}';
    }
}
