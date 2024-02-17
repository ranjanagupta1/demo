package com.basic.RESTautomationtraining;

import ch.qos.logback.core.net.SyslogOutputStream;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DynamicJsonLibraryTest {

    @Test(dataProvider="BooksDetails") //we are saying @Test to use the dataprovider named BooksDetails to achieve parametrizaion and execution the same script 3 times with the given sets of data in multi dimentional array
    public void addBook(String isbnVal,String aisleVal){
        baseURI = "http://216.10.245.166";

        //In the payload, aisle value must be unique and to achieve this we can DELETE that book everytime and create everytime
        String response = given().header("Content-Type","application/json")
                .body(Payload.addBookPayload(isbnVal,aisleVal)) //passing val here in addBookPayload("abdfc","jhgjh12") will only run once with these two values but when we pass var name then it will run for n defined nos
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath jp = ReUsableMethods.convertRawToJson(response);
        String ID = jp.get("ID");
        System.out.println(ID);

    }
    //Here we are achieving parametrization so that our test will run for multiple sets of book details
    @DataProvider(name="BooksDetails") //this is DataProvide name
    public Object[][] getData(){
        return new Object[][] {{"tgh","37gkil88"},{"jhjg","867jjg"},{"mkkj","2980hjk"}}; //creating a multi dimentional array object and initializing

    }

}
