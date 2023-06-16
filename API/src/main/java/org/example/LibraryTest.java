package org.example;

import Files.payloadfile;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LibraryTest {

    @Test

    public void library()
    {
        RestAssured.baseURI="http://216.10.245.166";
       String response = given().header("Content-Type","application/json")
                .body(payloadfile.librarypost()).when().post("Library/Addbook.php")
                .then().log().all().statusCode(200).extract().response().asString();
        JsonPath json = new JsonPath(response);
        String bookID = json.getString("ID");
        System.out.println(bookID);

        //here if ran the test again with same body, test will fail due to book already exist(we pass the same id)
        //as a solution you can call delete book from library request.
        //else pass ID of book as parameter to the method


    }
}
