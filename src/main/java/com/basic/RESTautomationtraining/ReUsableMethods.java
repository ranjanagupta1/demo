package com.basic.RESTautomationtraining;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
    public static JsonPath convertRawToJson(String jsonResponse) {
        JsonPath jp = new JsonPath(jsonResponse);
        return jp;
    }
}
