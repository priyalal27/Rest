package SerializationDeserialization;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class getMethod {

@Test
    public void deserialise(){

    RestAssured.baseURI="http://dummy.restapiexample.com";

    ParentPojo pp=given().expect().defaultParser(Parser.JSON).
            when().get("/api/v1/employees").as(ParentPojo.class);

        List<DataPojo> list=pp.getData_value();

        for (int i=0;i<list.size();i++){
    System.out.println(list);

        }
}

}
