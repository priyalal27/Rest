package StaticJSON;

import AssertionExample.ResuableClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StaticJSONClass {


    static  String ID;
    ResuableClass reuse= new ResuableClass();
    String uri="http://216.10.245.166";

    @Test
    public void addBook() throws Exception{

        RestAssured.baseURI=uri;
        Response response=given().contentType(ContentType.JSON).body(getJSONfromFile("C:\\Energy Components\\EC-12_1_workspace\\RestTest\\src\\main\\resources\\StaticJSONfile.json")).
                when().post("Library/Addbook.php").
                then().extract().response();

        JsonPath jpath=reuse.response(response);

        ID=(jpath.getString("ID"));
        System.out.println(ID);
    }

    public String getJSONfromFile(String path) throws Exception {

        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
