package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post07 extends AutomationBaseUrl {

    // API 11: POST To Create/Register User Account
    /*
     Test case

    Given
          https://automationexercise.com/api/createAccount

     And {
            “name”: “Taimur”,
            “title”: “coding01”,
            “firstname”: “Muhammad”,
            “lastname”: “Ahmed”,
            “email”: “new_user@gmail.com”,
            “password”: “coding01”,
            "birth_date": "12-06-1998",
            "company": "Oracle",
            "address1": "Thames Valley Park",
            "address2": "510 Oracle Parkway",
            "city": "Reading",
            "state": "England",
            "country": "UK",
            "zipcode": "RG6 1RA",
            "mobile_number": "+447-9877537812"
        }


    When
         User sends HTTP POST request
    Then
              HTTP Status Code is 201
    And
        Response code is 201
    And
       Response Message should be "User created!"

     */




    @Test
    public void post02()  {
        // Set the URL
        spec.pathParam("first", "createAccount");

        // Set the expected data

        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("name", "Taimur").
                param("title", "Mr").
                param("firstname", "Muhammad").
                param("lastname", "Ahmed").
                param("email", "user@newuser.com").
                param("password", "coding01").
                param("birth_date", "12-06-1998").
                param("company", "Oracle").
                param("address1", "Thames Valley Park").
                param("address2", "510 Oracle Parkway").
                param("city", "Reading").
                param("state", "England").
                param("country", "UK").
                param("zipcode", "RG6 1RA").
                param("mobile_number", "+447-9877537812").
                post("{first}");

        response.jsonPath().prettyPrint();

        JsonPath actualData = response.jsonPath();

        assertEquals("201", actualData.get("responseCode").toString());
        assertEquals("User created!", actualData.get("message"));


    }
}

