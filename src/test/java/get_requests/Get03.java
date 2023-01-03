package get_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get03 extends AutomationBaseUrl {

    // API 14: GET user account detail by email
    /*
     Given
            https://automationexercise.com/api/getUserDetailByEmail
      When
          User sends HTTP Get request
      And
          Request Parameters: email
      Then
         HTTP Status Code is 200
      And
         Response JSON: User Detail
       */




    @Test
    public void get02() {


        //Set the url
        spec.pathParam("first", "getUserDetailByEmail").queryParam("email");


        //Set the expected data

        //Send the request and get the response

        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("email","amina.pez+1@gmail.com").post("/{first}");
        response.jsonPath().prettyPrint();

        //Do Assertion
        // De-serialisation

        ResponsePojo actualData1 = JsonUtils.covertJsonToJavaObject(response.asString(),ResponsePojo.class);
        System.out.println("actualData = " + actualData1);

        assertEquals(200, response.statusCode());


//        List<String> userDetails = response.jsonPath().getList("products.brand");
//        System.out.println("userDetails = " + userDetails);


    }
}
