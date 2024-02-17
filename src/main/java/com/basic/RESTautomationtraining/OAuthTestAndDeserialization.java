package com.basic.RESTautomationtraining;

import com.basic.RESTautomationtraining.POJODeserialization.Api;
import com.basic.RESTautomationtraining.POJODeserialization.GetCoursesMainPojo;
import com.basic.RESTautomationtraining.POJODeserialization.WebAutomation;
import io.restassured.parsing.Parser;
import org.assertj.core.util.Arrays;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class OAuthTestAndDeserialization {
    public static void main(String[] args) {


        /* Below code is not usable as gmail log in is blocked by google via automation

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php";
        driver.get(url);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("guptaranjanasahu@gmail.com");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123@abcd123");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        String codeUrl = driver.getCurrentUrl();


        //1st need to generate the code;Steps=hit the url in browser->login to gmail->copy the url from browser->extract the code
        String codeUrl = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXmZnP4497eDg2ONNzV-9ZDDWl4grEJIXmouLEcR3Ie5axi6Ycn88vGZ2UGoDYUwng&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent";
        String partialCode = codeUrl.split("code=")[1];
        String actualCode = partialCode.split("&")[0];
        System.out.println(actualCode);
        //RESTAssured will convert special chars to numeric value so we need to explicitly tell not to do anything with the String Code


        //POST API-ExchangeRequest is triggered to get the accesss token by passing the code from above script
        //RESTAssured will convert special chars to numeric value so we need to explicitely tell not to do anything with the String Code so used URLencoding boolean method
        String response2 = given().urlEncodingEnabled(false)
                .queryParam("code",actualCode)
                .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParam("redirect_url","https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type","authorization_code")
                .when()
                .post("https://www.googleapis.com/oauth2/v4/token").then().extract().asString();
        JsonPath jp = new JsonPath(response2);
        String accessToken = jp.getString("access_token");
*/
        //Below is the basic code without deserialization
//        String response3 = given().queryParam("acccess_token",accessToken)
//                .when()
//                .get("https://rahulshettyacademy.com/getCourse.php").asString();

        //Using deserialization(Pojo) to get all the course api response and converting into the java objects
        String accessToken = "ya29.a0AfB_byA-Zw54pk6wPy5w82E7q7MksuhGeHaidr_1RVhEdw1RMdW3tKeOw3elg_2SbeKunBJGjIQnHGt2Lt9r2-EM-xtVe0MGIbA6yqmHA7rOhla5hYbQuhpgk9La4rbEJu3lfL6XS9-rPPlOc_DgPbvCBD6joBmz4j21aCgYKARkSARASFQGOcNnCDEtbzqRrhBFi7SokyiNh7A0171";
        //GET-Actual API is triggered to get the response getCourse api
        GetCoursesMainPojo obj = given().header("Content-Type","application/json")
                .queryParam("acccess_token",accessToken)
                .expect().defaultParser(Parser.JSON) //Using this expect().defaultparser to let the RestAssured know the expected type in as()
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").as(GetCoursesMainPojo.class); //adding POJO class for deserialization i.e whatever response will get from api will be converted into java obj(from json format) and one can print results using getter

        //API response={"instructor":"RahulShetty","url":"rahulshettycademy.com","services":"projectSupport","expertise":"Automation","courses":{"webAutomation":[{"courseTitle":"Selenium Webdriver Java","price":"50"},{"courseTitle":"Cypress","price":"40"},{"courseTitle":"Protractor","price":"40"}],"api":[{"courseTitle":"Rest Assured Automation using Java","price":"50"},{"courseTitle":"SoapUI Webservices testing","price":"40"}],"mobile":[{"courseTitle":"Appium-Mobile Automation using Java","price":"50"}]},"linkedIn":"https://www.linkedin.com/in/rahul-shetty-trainer/"}
        System.out.println(obj.getLinkedIn());
        System.out.println(obj.getInstructor());

        //Assignment1-Fetch the amount from Api pojo having courseTitle=SoapUI Webservices testing
        List<Api> apiResponse = obj.getCourses().getApi();

        for(int i=0;i< apiResponse.size();i++){
            if(apiResponse.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
                String price = apiResponse.get(i).getPrice();
                System.out.println(price);
                break;
            }
        }
        //Assignment2-Fetch all course title and match with expected titles
        String[] expectedTitles = {"Cypress","Protractor","Selenium Webdriver Java"};
        List<Object> convertedStringexpectedTitles = Arrays.asList(expectedTitles); //converted into list from array to assert with the same type
        ArrayList<String> storeActualTitles = new ArrayList<>(); //instead of array used ArrayList because it is dynamic in size whereas array is fixed
        List<WebAutomation> webAutomationResponse = obj.getCourses().getWebAutomation();
        for(int i=0;i<webAutomationResponse.size();i++){
            String courseTitle = webAutomationResponse.get(i).getCourseTitle();
            storeActualTitles.add(courseTitle);
            System.out.println(courseTitle);
        }
        Assert.assertTrue(storeActualTitles.equals(convertedStringexpectedTitles));



    }
}
