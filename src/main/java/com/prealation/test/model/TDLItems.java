package com.prealation.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TDLItems {

    @JsonProperty
    String item;

    @JsonProperty
    TDLStatus status;

    @JsonCreator
    public TDLItems(@JsonProperty("item") String item, @JsonProperty("status") TDLStatus status) {
        this.item = item;
        this.status = status;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TDLStatus getStatus() {
        return status;
    }

    public void setStatus(TDLStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TDLItems{" +
                "item='" + item + '\'' +
                ", status=" + status +
                '}';
    }
}
