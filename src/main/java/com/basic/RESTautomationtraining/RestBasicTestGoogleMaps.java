package com.basic.RESTautomationtraining;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*; //static packages will be
import static org.hamcrest.Matchers.equalTo;

/*
RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("/Hyderabad");
	ResponseBody body = response.getBody();
// First get the JsonPath object instance from the Response interface
	JsonPath jsonPathEvaluator = response.jsonPath();
	System.out.println("City received from Response " + jsonPathEvaluator.get("City"));

 */

public class RestBasicTestGoogleMaps {

    //6. Verify if Sum of all Course prices matches with Purchase Amount ;rest 5 mocked scenarios are written in the bottom
    @Test
    public void test1(){
        JsonPath jpMock = new JsonPath(Payload.payload3());
        int courseCount = jpMock.getInt("courses.size()");
        int totalSum = jpMock.getInt("dashboard.purchaseAmount");
        int actualSum = 0;
        int amount = 0;
        for (int i = 0; i < courseCount; i++) {
            int price = jpMock.getInt("courses[" + i + "].price");
            int copySold = jpMock.getInt("courses[" + i + "].copies");
            amount = price * copySold;
            actualSum = actualSum + amount;
            System.out.println(actualSum);
        }
        Assert.assertEquals(actualSum, totalSum);
    }


    public static void main(String[] args) throws IOException {

        baseURI = "https://rahulshettyacademy.com";
        //POST API
        String response = given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(Payload.bodyPayload1())
                .when()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();  //equalTo is from Hamcrest matcher package;JsonPath is expecting string so coverting here from json to string

        System.out.println(response);

        //extract place_id from its response
        JsonPath jp = ReUsableMethods.convertRawToJson(response); //It takes input as a String and parse into json
        String placeId = jp.getString("place_id"); //If parent child is there then parent.child format will follow
        System.out.println(placeId);

        //fetching response from GET api for the address
        String getResponse = given().log().all()
                .queryParam("key","qaclick123")
                .queryParam("place_id",placeId)
                .when()
                .get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath jp2 = ReUsableMethods.convertRawToJson(getResponse);
        String oldAddress = jp2.getString("address");
        System.out.println(oldAddress);
/*
        //PUT API;update new address for the same place_Id from above GET api
        String newAddress = "Summer Walk, Africa";
        given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(Payload.payload2())
                .when()
                .put(" /maps/api/place/update/json")
                .then().assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));//equalTo assertion is rest assured using hamcrest library
        //Now triggering GET to check if new address is added or not
        String getNewResponse = given().log().all()
                .queryParam("key","qaclick123")
                .queryParam("place_id",placeId)
                .when()
                .get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString(); //JsonPath is expecting string so coverting here from json to string

        JsonPath jp1 = ReUsableMethods.convertRawToJson(getNewResponse);
        String currentAddress = jp1.getString("address");
        System.out.println("Old Address is "+oldAddress+", And New Address is "+currentAddress);
        Assert.assertEquals(currentAddress,newAddress); //assertion using testng

        //-------------For static json or using payload from external path can follow this
        //readAllBytes() coverts the content into Byte and take parameter a "path of a file";
        Paths.get() take URL in its parameter;
        Files.readAllBytes(Paths.get()) is coverting into Byte and now to convert this into String we use "new String"

        String newAddress = "Summer Walk, Africa";
        given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Ranjana\\Doc\\payloads.json"))))
                .when()
                .put(" /maps/api/place/update/json")
                .then().assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));//equalTo assertion is rest assured using hamcrest library




//---------------------------------Mock and Test Without API but just the json-----------------------------------

        JsonPath jpMock = new JsonPath(Payload.payload3()); //instead of calling api and storing its response, here will directly use response without calling api

        //1. Print No of courses returned by API
        int courseCount = jpMock.getInt("courses.size()"); //size() is a method in JsonPath to get count from an array
        System.out.println(courseCount);

        //2.Print Purchase Amount
        int totalAmount = jpMock.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        //3. Print Title of the first course
        String firstCourseTitle = jpMock.getString("courses[0].title");
        System.out.println(firstCourseTitle);

        //4. Print All course titles and their respective Prices
        for(int i=0;i<courseCount;i++){
            String title = jpMock.getString("courses["+i+"].title"); //i is var so use + symbol
            int price = jpMock.getInt("courses["+i+"].price");
            System.out.println(title+ " " +price);
        }

        //5. Print no of copies sold by RPA Course
        for(int i=0;i<courseCount;i++){
            String getTitleRPA = jpMock.getString("courses["+i+"].title");
            if(getTitleRPA.equalsIgnoreCase("RPA")){
                int copiesSold = jpMock.getInt("courses["+i+"].copies");
                System.out.println(copiesSold);
                break;
            }
        }

        //6. Verify if Sum of all Course prices matches with Purchase Amount
        //this code is written on top

*/








    }
}
