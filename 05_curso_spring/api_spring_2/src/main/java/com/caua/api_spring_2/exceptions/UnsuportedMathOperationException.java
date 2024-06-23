package com.caua.api_spring_2.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UnsuportedMathOperationException(String message) {
        super(message);
    }
}
