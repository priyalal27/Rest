package OAuthExample.AuthCode;

import AssertionExample.ResuableClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ActualURL {
    ResuableClass reuse= new ResuableClass();

    @Test(priority = 1)
    public void getToken(){
        RestAssured.baseURI="https://rahulshettyacademy.com";

        Response response=
                given().
                        queryParam("access_token","ya29.a0Ae4lvC3ztWH-KIwYIoujnRalEGNOOMb9Ze6JXB4ORO1SHkfqlpVz8Mcs9AppV_PC8IaJkXMmkiCJ4jR685jr1X6r45yZIJH2URwS-2h3dN8r_Z8bhWq5tZFIu06mQ14YWAEJa_reQIbKDQq4XtRDfA3ZiW1400cL1fMy").
                            when().get("/getCourse.php").
                                then().log().all().extract().response();



        JsonPath jpath=reuse.response(response);
        System.out.println(jpath);
    }
}
