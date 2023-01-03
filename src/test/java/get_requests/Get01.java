package get_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get01 extends AutomationBaseUrl {

    // API 1: Get All Products List
    /*

    Test case:
    Given
          https://automationexercise.com/api/productsList
    When
        User sends Get Request
    Then
        Http status code is 200
     And
        Content type is JSON
      And
         Response body should be like all products list

     */
    @Test
    public void get01(){
        // Set the URL
        spec.pathParam("first", "productsList");

        // Set the expected data


        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.jsonPath().prettyPrint();

        // Do Assertion
        JsonPath json = response.jsonPath();
        List<Integer> list = json.getList("products.id");
        System.out.println("list = " + list);
        System.out.println(list.size());

        response.then().assertThat().statusCode(200).contentType(ContentType.HTML);
        assertEquals(34,list.size());








    }
}
