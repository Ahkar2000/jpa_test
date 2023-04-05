package com.example.jpatest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    String errorCode;
    String message;
    Object result;
    LocalDateTime dateTime;

    public BaseResponse(String errorCode,String message,Object result){
        this.errorCode = errorCode;
        this.message = message;
        this.result = result;
        this.dateTime = LocalDateTime.now();
    }
}
