package AssertionExample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadJSON {

public String readJSONAdd() throws Exception {

    FileReader read =  new FileReader("C:\\Energy Components\\EC-12_1_workspace\\RestTest\\src\\main\\resources\\add.json");
    JSONParser parser = new JSONParser();
    Object obj=parser.parse(read);

    JSONObject jsonobj=(JSONObject)obj;


    return jsonobj.toJSONString();
}



    public String readJSONDelete() throws Exception {

        FileReader read =  new FileReader("C:\\Energy Components\\EC-12_1_workspace\\RestTest\\src\\main\\resources\\delete.json");
        JSONParser parser = new JSONParser();
        Object obj=parser.parse(read);

        JSONObject jsonobj=(JSONObject)obj;
        return jsonobj.toJSONString();
    }
}
