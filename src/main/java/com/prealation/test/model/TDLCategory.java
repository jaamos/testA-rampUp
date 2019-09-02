package com.prealation.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TDLCategory {

    @JsonProperty
    String name;

    @JsonProperty
    TDLCategoryColor categoryColor;

    @JsonCreator
    public TDLCategory(@JsonProperty("name") String name, @JsonProperty("categoryColor") TDLCategoryColor categoryColor) {
        this.name = name;
        this.categoryColor = categoryColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TDLCategoryColor getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(TDLCategoryColor categoryColor) {
        this.categoryColor = categoryColor;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", color=" + categoryColor +
                '}';
    }
}