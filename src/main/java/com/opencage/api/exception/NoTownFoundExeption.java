package com.opencage.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoTownFoundExeption extends RuntimeException {
    public NoTownFoundExeption(String message) {
        super(message);
    }
}
