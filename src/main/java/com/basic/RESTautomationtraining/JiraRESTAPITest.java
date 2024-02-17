package com.basic.RESTautomationtraining;


import static io.restassured.RestAssured.*;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class JiraRESTAPITest {

    public static void main(String[] args) {


        baseURI = "http://localhost:8080";
        //Create login API
        SessionFilter session = new SessionFilter(); //the session obj will store all the login response

        String response = given().header("Content-Type","application/json").body("{ \"username\": \"ranjana\", \"password\": \"jira123456\" }")
                .filter(session)  // after triggering the api, session obj will capture all the login info response and later this will be passed onto all the apis just by using one obj
                .when()
                .post("/rest/auth/1/session")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();


        //Add Comment API
        String message = "This is a new comment added";
        String commentResponse = given().header("Content-Type","application/json")
                .pathParam("issueId",10000).body("{\n" +
                "    \"body\": \""+message+"\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}")
                .filter(session)
                .when()
                .post("/rest/api/2/issue/{issueId}/comment") //{issueId}-restassured will consider variable for any param with curly braces and look into defined pathparam attribute then move to next resource param
                .then()
                .log().all()
                .assertThat().statusCode(201).extract().response().asString();
        JsonPath jpComment = new JsonPath(commentResponse);
        String commentId = jpComment.getString("id"); //extracting the id of the added comment
/*
        //Add Attachment in the jira issue
        given().header("X-Atlassian-Token","no-check")
                .filter(session)
                .pathParam("issueId",10000)
                .header("Content-Type","multipart/form-data")
                .multiPart("File",new File("src/main/java/com/basic/RESTautomationtraining/jira.txt")) //multipart(fileName,filePath) and for filepath we need to create obj of file class and store the path
                .when()
                .post("/rest/api/2/issue/{issueId}/attachments")
                .then().assertThat().statusCode(200);

        //Get Issue Details but only for comment field of jira
        String issueDetails = given().relaxedHTTPSValidation().pathParam("issueId",10000)
                .queryParam("fields","comment")
                .filter(session)
                .when()
                .get("/rest/api/2/issue/{issueId}")
                .then()
                .extract().response().asString();
        System.out.println(issueDetails); //this will return all the 41 fields if we remove query param; To get particular fields only, we used query param

        //Here we are checking if any specific comment is added perfectly or not;We are getting all the comments count->iterating->matching the commentId with the one created->extracting body
        JsonPath jp3 = new JsonPath(issueDetails);
        int countOfComments = jp3.getInt("fields.comment.comments.size()"); //getting the count of all the comments
        for(int i=0;i<countOfComments;i++){
            String issueCommentId = jp3.get("fields.comment.comments["+i+"].id").toString(); //getting id of each comment;get() will get any return type and then convert into string
            //Now will match each "issueCommentId" with earlier "commentId" to check if same comment is present or not
            if(issueCommentId.equalsIgnoreCase(commentId)){
                String commentBody = jp3.get("fields.comment.comments["+i+"].body").toString();
                System.out.println(commentBody);
                Assert.assertEquals(commentBody,message);
            }
        }
*/

    }
}
