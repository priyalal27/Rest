package OAuthExample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getCode {


    @Test
    public void getcode(){

        RestAssured.baseURI="https://accounts.google.com/";

        given().contentType(ContentType.JSON).queryParam("scope","https://www.googleapis.com/auth/userinfo.email").
                queryParam("auth_url","https://accounts.google.com/o/oauth2/v2/auth").
                queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
                queryParam("response_type","code").
                queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
                queryParam("state","verifyfjdss").

                when().get("o/oauth2/v2/auth").
                    then().log().all();
        //System.out.println(code);
    }
}
