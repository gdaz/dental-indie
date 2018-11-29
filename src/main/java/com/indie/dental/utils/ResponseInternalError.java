package com.indie.dental.utils;

import com.indie.dental.beans.ResponseBodyBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ResponseInternalError implements SetResponseBodyImpl {

    @Override
    public ResponseEntity<?> responseBody(Object o) {
        ResponseBodyBean responseBodyBean = new ResponseBodyBean(HttpStatus.INTERNAL_SERVER_ERROR.value(), o);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(responseBodyBean, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
