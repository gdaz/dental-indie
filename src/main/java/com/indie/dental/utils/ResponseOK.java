package com.indie.dental.utils;

import com.google.gson.JsonObject;
import com.indie.dental.beans.ResponseBodyBean;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseOK implements SetResponseBodyImpl {

    @Override
    public ResponseEntity<?> responseBody(Object o) {
        ResponseBodyBean responseBodyBean = new ResponseBodyBean(HttpStatus.OK.value(), o);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(responseBodyBean, headers, HttpStatus.OK);
    }
}
