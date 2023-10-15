package com.spring.microservice.payload.response;

import lombok.Data;

@Data
public class MsgResponse {

    private String message;
    private String code;
    private Object data;
    private String status;

    public MsgResponse(String message,String code,String status,Object data) {
        this.message = message;
        this.data = data;
        this.code = code;
        this.status = status;
    }
}
