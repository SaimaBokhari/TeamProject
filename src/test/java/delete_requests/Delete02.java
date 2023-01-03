package delete_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends AutomationBaseUrl {

    // API 12: DELETE METHOD To Delete User Account

      /*
     Given
          https://automationexercise.com/api/deleteAccount
      When
          User sends Delete request
       And
          Request Parameters: email, password
      Then
          Status Code is 200
       And
          Response message : Account deleted!
     */

    @Test
    public void delete02() {
        //Set the url
        spec.pathParam("first", "deleteAccount");

        //Send the request and get the response
        Response response = given().spec(spec).
                urlEncodingEnabled(true).
                param("email", "user007@newuser.com").
                param("password", "coding01").
                //header("Accept", ContentType.JSON.getAcceptHeader()).
                delete("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion


        ResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData);

//
        assertEquals(200, response.statusCode());
        assertEquals("200", actualData.getResponseCode().toString());
        assertEquals("Account deleted!", actualData.getMessage());

    }
}
