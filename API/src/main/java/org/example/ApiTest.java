package org.example;

import Files.payloadfile;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Hello world!
 *
 */
public class ApiTest
{
    public static void main( String[] args )
    {

        //Given : using give you can input all the details
        //When : Submit API - Resource and http method
        //Then : Validate the response

        //Post the place and address
        RestAssured.baseURI ="https://rahulshettyacademy.com/";
       String response =  given().log().all().queryParam("key","qaclick123").header("Contect-Type","application/json")
                .body(payloadfile.AddPlace())
                .when().post("maps/api/place/add/json")
                //here equalTo is imported from harmcrest package.
                .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("server",equalTo("Apache/2.4.41 (Ubuntu)")).extract().response().asString();
        JsonPath json = new JsonPath(response);
        String placeId = json.getString("place_id");
        System.out.println(placeId);

        //Update the place :

        String newAdress = "70 winter walk, USA11";
        given().log().all().queryParam("key","qaclick123").header("Contect-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAdress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").when().put("maps/api/place/update/json").then().log().all().assertThat().body("msg",equalTo("Address successfully updated"));
        //Get the updated place:

        String updatePlace = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId).when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(updatePlace);
        String ActualAddress = js.getString("address");
        System.out.println(ActualAddress);
        Assert.assertEquals(ActualAddress,newAdress);
    }
}
