package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.baseURI;

public class UtilsREST {

    public RequestSpecification requestSpecification() throws FileNotFoundException {
        baseURI = "https://rahulshettyacademy.com";

        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseURI)
                .addQueryParam("\"key\",\"qaclick123\"").setContentType(ContentType.JSON)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();
        return req;
    }
}
