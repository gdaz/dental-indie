package com.indie.dental.exception;

public class PatientNotFoundErrorCode extends BaseException {
    @Override
    int getErrorCode() {
        return 500;
    }
}
