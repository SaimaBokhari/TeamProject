package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.LoginPojo;
import pojos.ResponsePojo;
import utils.JsonUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post06 extends AutomationBaseUrl {

    //API 10: POST To Verify Login with invalid details

        /*
     Given
          https://automationexercise.com/api/verifyLogin
     And
         {
            “email”: “new_user@gmail.com”,
            “password”: “coding01”
        }
      When
          User sends Post request
      Then
          Status Code is 404
       And
          Response message : User not found!
     */

    @Test
    public void post06() {

        //Set the url
        spec.pathParam("first", "verifyLogin");

        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("email", "na.pez+1@gmail").param("password", "zen").
                header("Accept", ContentType.JSON.getAcceptHeader()).post("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion

//         ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//         System.out.println("actualData = " + actualData);

        ResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData);

//
        assertEquals(200, response.statusCode());
        assertEquals("404", actualData.getResponseCode().toString());
        assertEquals("User not found!", actualData.getMessage());


    }
}

