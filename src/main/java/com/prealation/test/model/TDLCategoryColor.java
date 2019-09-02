package com.prealation.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TDLCategoryColor {
    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    ORANGE("ORANGE"),
    PURPLE("PURPLE"),
    PEACH("PEACH"),
    GOLD("GOLD"),
    CYAN("CYAN"),
    MAGENTA("MAGENTA");

    @JsonProperty
    String color;

    TDLCategoryColor(String color) {
        this.color = color;
    }

    @JsonValue
    public String getColor() {
        return color;
    }

    @JsonCreator
    public static TDLCategoryColor byColor(String color){
        for(TDLCategoryColor thisTDLCategoryColor : values()){
            if(thisTDLCategoryColor.color.equalsIgnoreCase(color)){
                return thisTDLCategoryColor;
            }
        }
        throw new IllegalStateException("Unable to find Color by color=" + color);
    }
}