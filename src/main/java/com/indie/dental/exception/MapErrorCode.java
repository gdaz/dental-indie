package com.indie.dental.exception;

import org.json.JSONObject;

public class MapErrorCode {
    public int getErrorDescription(BaseException e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", e.getErrorCode());
        return  e.getErrorCode();
    }
}
