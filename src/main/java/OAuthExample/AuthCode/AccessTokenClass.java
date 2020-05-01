package OAuthExample.AuthCode;

import AssertionExample.ResuableClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccessTokenClass {

    static String AccessToken;
    ResuableClass reuse= new ResuableClass();
    String code="4%2FzAF_WLMWa8o_Vv1GwfvAQM1Eu9s_tV9bLZVtmGAtwpDo-3nAmL2mp4f4e1DXMUujtMlh-XoR2mbTkgl2GYEMM7w";


    @Test(priority = 0)
    public void getToken(){
        RestAssured.baseURI="https://www.googleapis.com/";

        String response= given()
                .urlEncodingEnabled(false)
                .queryParams("code", code)
                .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type","authorization_code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token")
                .asString();

        JsonPath jpath= new JsonPath(response);
        AccessToken=jpath.getString("access_token");
        System.out.println(AccessToken);
    }

}
