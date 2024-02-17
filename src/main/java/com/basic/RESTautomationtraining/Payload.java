package com.basic.RESTautomationtraining;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

public class Payload {
    public static String bodyPayload1() {
        return "{\n" +
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
    }

    public static String payload2() {
        return "{\n" +
                "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }

    public static String payload3() {
        return "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 910,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6},\n" +
                "{\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "}]\n" +
                "}\n";
    }

    public static String addBookPayload(String isbnVal, String aisleVal) {
        String payload = "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"" + isbnVal + "\",\n" +
                "\"aisle\":\"" + aisleVal + "\",\n" +
                "\"author\":\"John foe\"\n" +
                "}"; //aisleVal and isbnVal are dynamic variable hence need to use "+var+" as its not a String
        return payload;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new ObjectMapper().readTree("{\"instructor\":\"rahulshetthy\",\"url\":\"rahulshettyacademy.com\",\"dashboard\":{\"purchaseAmount\":910,\"website\":\"rahulshettyacademy.com\"},\"courses\":[{\"title\":[{\"title1\":\"Selenium\"},{\"title2\":\"Python\"}],\"price\":50,\"copies\":6},{\"title\":\"Cypress\",\"price\":40,\"copies\":4},{\"title\":\"RPA\",\"price\":45,\"copies\":10}]}"));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }


}
