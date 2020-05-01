package AssertionExample;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResuableClass {

    public JsonPath response(Response resposne){
        // convert response to String
        String ResponseString=resposne.asString();
        //send the string to JSONPATH class
        JsonPath jpath= new JsonPath(ResponseString);
        // get the value from jsonpath through get method


        return jpath;
    }
}
