package com.home.location.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaiementNotFoundException extends Exception {
    public PaiementNotFoundException() {
        super("PaiementNotFoundException");
    }
}
