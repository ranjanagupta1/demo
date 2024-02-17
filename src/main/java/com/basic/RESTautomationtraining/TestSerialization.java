package com.basic.RESTautomationtraining;

import com.basic.RESTautomationtraining.POJOSerialization.AddPlaceMainPojo;
import com.basic.RESTautomationtraining.POJOSerialization.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class TestSerialization {
    public static void main(String[] args) {
        baseURI = "https://rahulshettyacademy.com";
        //In body will send serialized objects for the convertion of java obj into json and pass to api req body

        AddPlaceMainPojo serObj = new AddPlaceMainPojo();
        serObj.setAccuracy(109);
        serObj.setAddress("SN 123 Address 120917 West");
        serObj.setLanguage("English");
        serObj.setName("Raghv");
        serObj.setWebsite("www.insta.com");
        serObj.setPhone_number("123-00-8710-1567");

        List<String> types = new ArrayList<>();
        types.add("Street");
        types.add("shop new");
        serObj.setTypes(types);

        Location locObj = new Location();
        locObj.setLat(0.5467);
        locObj.setLng(6.8752);
        serObj.setLocation(locObj);



        String response = given().queryParam("\"key\",\"qaclick123\"")
                .header("Content-Type","application/json")
                .body(serObj)
                .when()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response);

        String getNewResponse = given().log().all()
                .queryParam("key","qaclick123")
                .queryParam("place_id","084c1410e5b301754467da07a5105971")
                .when()
                .get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(getNewResponse);

    }
}
