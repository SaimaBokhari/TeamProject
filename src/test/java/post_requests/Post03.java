package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.ResponsePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post03 extends AutomationBaseUrl {
    // API 6: POST To Search Product without search_product parameter
    /*
    API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Response Code: 400
Response Message: Bad request, search_product parameter is missing in POST request.
     */
    @Test
    public void post03() throws IOException {
        //Set the url
        spec.pathParam("first", "searchProduct");

        // Set the expected data


        //Send the request and get the response
        Response response = given().spec(spec).when().post("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion
        // De-serialisation
        ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
        System.out.println("actualData = " + actualData);

        // Do assertion
        assertEquals(200, response.statusCode());
        assertEquals("400", actualData.getResponseCode().toString());
        assertEquals("Bad request, search_product parameter is missing in POST request.", actualData.getMessage());



    }

}
