package DynamicJSON;

import AssertionExample.ResuableClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestClass {
    ResuableClass reuse= new ResuableClass();
    static String uri="http://216.10.245.166";
    static String ID;
    PayloadClass payload= new PayloadClass();


    @Test(dataProvider = "BookData")
    public void addBook(String isbn, String aisle){

        RestAssured.baseURI=uri;
        Response response=given().contentType(ContentType.JSON).body(payload.AddBook(isbn,aisle)).
                when().post("Library/Addbook.php").
                    then().extract().response();

        JsonPath jpath=reuse.response(response);

        ID=(jpath.getString("ID"));
        System.out.println(ID);
    }

    @Test(dependsOnMethods = "addBook", dataProvider = "DeleteBook")
    public void deleteBook(String ID){
        RestAssured.baseURI=uri;
        Response response=given().contentType(ContentType.JSON).body(payload.DeleteBook(ID)).
                when().post("/Library/DeleteBook.php").
                then().extract().response();

        JsonPath jpath=reuse.response(response);

        String msg=jpath.getString("msg");
        System.out.println(msg);
    }


    @DataProvider(name="BookData")
    public Object[][] getData(){
        Object[][] obj=new Object[][]{{"xyz","123"},{"abc","098"},{"qwe","1234"},{"poi","098"},{"ser","765"}};
        return obj;
    }


    @DataProvider(name="DeleteBook")
    public Object[][] deletedata(){
        Object[][] obj = new Object[][]{{"XYZ123"},{"abc098"},{"qwe1234"},{"poi098"},{"ser765"}};
        return obj;
    }
}
