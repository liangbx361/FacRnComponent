package com.nd.sdp.ele.rct.exam.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorEntry {
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String  message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}