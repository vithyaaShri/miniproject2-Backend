package com.miniproject2.miniproject2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
//Api exception
@Getter
@AllArgsConstructor
public class UserApiException extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;
}
