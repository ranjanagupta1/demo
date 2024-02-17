package com.basic.RESTautomationtraining.E2EAutoEcommerce;

import com.basic.RESTautomationtraining.ReUsableMethods;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class EcommerceMain {
    public static void main(String[] args) {
        //POST - Ecommerce Login API---------Website "https://rahulshettyacademy.com/client"-----------------------------------------------------------------------------------------------
/*
        baseURI="https://rahulshettyacademy.com";
        //Below way is basic
        Response response = given().header("Content-Type","application/json")
                .body("{\n" +
                        "    \"userEmail\": \"guptaranjanasahu@gmail.com\",\n" +
                        "    \"userPassword\": \"Ranjana555\"\n" +
                        "}") //----------This payload is being sent below using pojo class
                .when()
                .post("/api/ecom/auth/login")
                .then().extract().response();
        String responseString1 = response.asString();
        System.out.println(responseString1);
        JsonPath jpObj = ReUsableMethods.convertRawToJson(responseString1); //no need to create obj again using "new" as we have already created once in method "ReUsableMethods.convertRawToJson()"
        String token = jpObj.getString("token");
        System.out.println(token);
*/
        //this way of POST login is using pojo and RequestSpecification
        RequestSpecification loginReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
        PojoEcomLoginReqSer pObj = new PojoEcomLoginReqSer(); //Creating obj of serialized  class to set the payload attribute's values
        pObj.setUserEmail("guptaranjanasahu@gmail.com");
        pObj.setUserPassword("Ranjana555");

        RequestSpecification rs =given().spec(loginReq)
                .body(pObj);

        PojoEcomLoginResponseDeSer responseOfApi = rs.when()
                .post("/api/ecom/auth/login")
                .then().extract().response().as(PojoEcomLoginResponseDeSer.class);
        String token = responseOfApi.getToken();
        String userId = responseOfApi.getUserId();
        System.out.println(userId);



        //POST - Create Product--------------------------------------------------------------------------------------------------------------------------------------
        //As we are sending data in form-data not in json format, we will not use content-type JSON. Also we need to pass token from Login api response
        RequestSpecification baseReqWithToken = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token)
                .build();
        ResponseSpecification res = new ResponseSpecBuilder()
//                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        RequestSpecification reqCreateProduct = given().spec(baseReqWithToken)
                .param("productName","Laptop").param("productPrice","2300")
                .param("productAddedBy",userId).param("productDescription","Addias Originals")
                .param("productCategory","fashion").param("productFor","women")
                .param("productSubCategory","shirts")
                .multiPart("productImage",new File("C:\\Users\\dell\\Downloads\\tom.jpg")); //multipart is used to add any attachment using restAssured and param used to add payload in form-data(not json type)
        String responseCreateProduct = reqCreateProduct.when().post("/api/ecom/product/add-product")
                .then()
                .spec(res)
                .extract().response().asString();
        System.out.println(responseCreateProduct);

        JsonPath jpObj2 = ReUsableMethods.convertRawToJson(responseCreateProduct); //no need to create obj again using "new" as we have already created once in method "ReUsableMethods.convertRawToJson()"
        String productID = jpObj2.getString("productId");
        System.out.println(productID);

        //POST - Create Order for the product added above-----------------------------------------------------------------------------------------------------------------------------

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCountry("India");
        orderDetail.setProductOrderedId(productID);

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail> ();//Creating list because Orders is of type List and adding the obj(having all the stored data)
        orderDetailList.add(orderDetail);

        Orders order = new Orders();
        order.setOrders(orderDetailList); //this method is expecting to receive the List obj

        RequestSpecification reqCreateOrder = given().spec(baseReqWithToken)
                .contentType(ContentType.JSON)
                .body(order);
        String responseAddOrderToCart = reqCreateOrder.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
        System.out.println(responseAddOrderToCart);

        //DELETE - Delete any product -------------------------------------------------------------------------------------------------------------------------------------------

        RequestSpecification reqDeleteOrder = given().spec(baseReqWithToken)
                .contentType(ContentType.JSON).pathParam("productID",productID);
        String productDeleteResponse = reqDeleteOrder.when().delete("/api/ecom/product/delete-product/{productID}").then().log().all().extract().response().asString();

        JsonPath jpObj4 = ReUsableMethods.convertRawToJson(productDeleteResponse);
        Assert.assertEquals("Product Deleted Successfully",jpObj4.get("message"));
        System.out.println(productID);

        //DELETE - Delete any Order from cart---------------------------------------------------------------------------------------------------------------------------------------

        RequestSpecification reqDeleteOrderFromCart= given().spec(baseReqWithToken)
                .contentType(ContentType.JSON).pathParam("userId",userId).pathParam("productID",productID);
        String productDeleteOrderFromCartResponse = reqDeleteOrderFromCart.when().delete("/api/ecom/user/remove-from-cart/{userId}/{productID}").then().log().all().extract().response().asString();

        JsonPath jpObj5 = ReUsableMethods.convertRawToJson(productDeleteOrderFromCartResponse);
        Assert.assertEquals("Product Removed from cart",jpObj5.get("message"));
        System.out.println(productID);

    }
}
