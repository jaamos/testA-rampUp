package com.prealation.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TDLStatus {
    COMPLETE(1), PENDING(0);

    @JsonProperty
    Integer code;

    TDLStatus(Integer code) {
        this.code = code;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }

    @JsonCreator
    public static TDLStatus byCode(Integer code){
        for(TDLStatus status : values()){
            if(status.code.equals(code)){
                return status;
            }
        }
        throw new IllegalStateException("Unable to find Status by code: " + code);
    }
}