package put_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Put_Pojo;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Put02 extends AutomationBaseUrl {

    // API 13: PUT METHOD To Update User Account
    /*
          Given
                https://automationexercise.com/api/updateAccount
           And
              Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss), birth_date, birth_month, birth_year, firstname, lastname, company, address1, address2, country, zipcode, state, city, mobile_number
          When
              user sends Put Request
          Then
              HTTP Status Code is 200
           And
              Response Code is 405
            And
               Response Message is :" User updated!"

     */
    /*
    API URL: https://automationexercise.com/api/updateAccount
Request Method: PUT
Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss), birth_date, birth_month, birth_year, firstname, lastname, company, address1, address2, country, zipcode, state, city, mobile_number
Response Code: 200
Response Message: User updated!
     */

    @Test
    public void put02(){
        //Set the Url
        spec.pathParam("first","updateAccount");

        //Set the expected data


        //Send the request and get the response
        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("name", "Taimur").
                param("title", "Mr").
                param("firstname", "Muhammad").
                param("lastname", "Ahmed").
                param("email", "newuser@newuser.com").
                param("password", "coding01").
                param("birth_date", "12-06-2000").
                param("company", "Oracle").
                param("address1", "Thames Valley Park").
                param("address2", "510 Oracle Parkway").
                param("city", "Reading").
                param("state", "England").
                param("country", "UK").
                param("zipcode", "RG6 1RA").
                param("mobile_number", "+447-9877537873").
                put("{first}");

        response.jsonPath().prettyPrint();

        //Do Assertion
        //De-Serialization

        JsonPath actualData = response.jsonPath();

        assertEquals("200", actualData.get("responseCode").toString());
        assertEquals("User updated!", actualData.get("message"));





//       ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//        System.out.println("actualData = " + actualData);
//
//
//        // Do assertion
//        assertEquals(200, response.statusCode());
//        assertEquals("405", actualData1.getResponseCode().toString());
//        assertEquals("This request method is not supported.", actualData);

    }

}
