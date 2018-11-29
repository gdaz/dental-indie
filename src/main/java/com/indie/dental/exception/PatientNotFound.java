package com.indie.dental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PatientNotFound extends RuntimeException {
    public PatientNotFound() {
        super("Not found patient");
    }
}
