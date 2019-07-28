package com.home.location.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends Exception{
    public LocationNotFoundException() {
        super("LocationNotFoundException");
    }
}
