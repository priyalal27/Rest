package AssertionExample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AssertionExmp {

     PropertiesRead readPropperty= new PropertiesRead();
     ReadJSON readjson = new ReadJSON();
     WritetoJSON jsonwrite= new WritetoJSON();
    ResuableClass reuse= new ResuableClass();

     static String placeid;


    @Test(priority = 0)
    public void AddPlace()throws  Exception{
        RestAssured.baseURI=readPropperty.readProperties();

        Response response=
                given().accept(ContentType.JSON).body(readjson.readJSONAdd()).
                        when().post("maps/api/place/add/json").
                        then().log().all().assertThat().body("status",equalTo("OK")).
                        header("Transfer-Encoding",equalTo("chunked")).extract().response();

        JsonPath jpath=reuse.response(response);
        placeid=jpath.get("place_id");
        jsonwrite.writeToJSON_Delete();
        jsonwrite.writeToJSON_update();
    }



    @Test(priority = 1)
    public void DeletePlace()throws  Exception{
        RestAssured.baseURI=readPropperty.readProperties();

        Response response=
                given().accept(ContentType.JSON).param("key","qaclick123").body(readjson.readJSONDelete()).log().all().

                            when().put("maps/api/place/delete/json").
                        then().log().all().assertThat().body("status",equalTo("OK")).
                        header("Transfer-Encoding",equalTo("chunked")).extract().response();

        JsonPath jpath=reuse.response(response);// called resuable class
        placeid=jpath.get("place_id");
    }

    @Test(enabled = false)
    public void updatePlace()throws  Exception{
        RestAssured.baseURI=readPropperty.readProperties();
         given().accept(ContentType.JSON).param("key","qaclick123").body(readjson.readJSONDelete()).
                        when().put("maps/api/place/update/json").
                        then().body("msg", equalTo("Address successfully updated"));


    }
}
