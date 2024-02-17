package com.basic.automation.customer;

import com.basic.demo.Util.PropertyHandler;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetCustomerById {

    static Properties configproperties = PropertyHandler.loadPropertyFile("config");
    public static final String CUSTOMER_URL = configproperties.getProperty("customerUrl");

    @Test
    public void getCustomerById(){
        Response response = given().queryParam("limit",10).when().get(CUSTOMER_URL);
        System.out.println(response.getBody().asString());
    }

}
