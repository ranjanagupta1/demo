package com.basic.RESTautomationtraining;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class PracticeREST {
    public static void main(String[] args) {
        String body1="{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
        String res = given().log().all()
                .baseUri("https://rahulshettyacademy.com")
                .header("Content-Type","application/json")
                .queryParam("key","qaclick123")
                .body(body1)
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(res);
        //---extract any field(place_id) from response and store in var
        JsonPath obj = new JsonPath(res);
        String placeId= obj.getString("place_id");
        System.out.println(placeId);

    }
}
