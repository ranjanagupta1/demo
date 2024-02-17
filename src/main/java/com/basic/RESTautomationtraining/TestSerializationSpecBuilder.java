package com.basic.RESTautomationtraining;

import com.basic.RESTautomationtraining.POJOSerialization.AddPlaceMainPojo;
import com.basic.RESTautomationtraining.POJOSerialization.Location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestSerializationSpecBuilder {
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


/*
        Response response = given().queryParam("\"key\",\"qaclick123\"")
                .header("Content-Type","application/json")
                .body(serObj)
                .when()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();
        String responseString = response.asString();
        System.out.println(responseString);

        String getNewResponse = given().log().all()
                .queryParam("key","qaclick123")
                .queryParam("place_id","084c1410e5b301754467da07a5105971")
                .when()
                .get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(getNewResponse);
*/
        //Above APIs can be triggered using Spec Builder
        //Create object of RequestSpecBuilder class and the return type of obj will be RequestSpecification. "req" is the obj of requestspecbuilder.
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("\"key\",\"qaclick123\"").setContentType(ContentType.JSON).build();
        ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        //--------POST API
        Response response = given().spec(req)
                .body(serObj)
                .when()
                .post("/maps/api/place/add/json")
                .then().spec(res).extract().response();
        String responseString = response.asString();
        System.out.println(responseString);

        //-----------GET API
        RequestSpecification rsObj = given().spec(req)
                .queryParam("\"place_id\",\"4e9a265f6b39b39c9cd4a008d2868376\""); //Separating the request

        Response getNewResponse =  rsObj.when()
                .get("/maps/api/place/get/json")
                .then().spec(res)
                .extract().response();
        String getResponseString = getNewResponse.asString();
        System.out.println(getResponseString);


    }
}
