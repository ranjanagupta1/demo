package restFramework.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.UtilsREST;
import resources.TestDataBuildREST;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

import static io.restassured.RestAssured.given;
/*
Moved the test data/payload in TestDataBuildREST class
Here create the obj of TestDataBuildREST and use its obj to call the method in order to add the payload in req
In TestDataBuildREST class- create method and return the AddPlaceMainPojo obj created under that method
 */

public class StepDef_AddPlaceApiREST extends UtilsREST {


    ResponseSpecification resspec;
    RequestSpecification res;
    Response response;
    TestDataBuildREST payloadClassObj = new TestDataBuildREST();
    @Given("add place payload")
    public void add_place_payload() {

        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }
    @When("user calls {string} using POST http request")
    public void user_calls_using_post_http_request(String string) throws FileNotFoundException {

        response = given().spec(requestSpecification())
                .body(payloadClassObj.addPlacePayload())
                .when()
                .post("/maps/api/place/add/json")
                .then().spec(resspec).extract().response();
    }
    @Then("the API call is success with status {int}")
    public void the_api_call_is_success_with_status(Integer int1) {
        assertEquals("Status is 200",200,response.getStatusCode()); //assertEquals is junit method
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string1) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        assertEquals(string1,js.get(string).toString());
    }

    String response1 = given()
            .baseUri("hvgccvjk")
            .header("Auth","json")
            .pathParam("abc","123")
            .queryParam("gkhb","jgvj")
            .when()
            .get("/abc/opt")
            .then().statusCode(200).extract().response().toString();
    JsonPath jp5= new JsonPath(response1);

}
