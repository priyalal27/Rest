package AssertionExample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class WritetoJSON {

    public void writeToJSON_Delete() throws Exception {

        JSONArray arr= new JSONArray();
        JSONObject binding = new JSONObject();
        JSONObject placedetail= new JSONObject();

        String placeid= AssertionExmp.placeid;
        placedetail.put("place_id",placeid);

        System.out.println(arr);

        FileWriter writer = new FileWriter("C:\\Energy Components\\EC-12_1_workspace\\RestTest\\src\\main\\resources\\delete.json");
        writer.write(placedetail.toString());
        writer.flush();
    }

    public void writeToJSON_update() throws Exception {

        JSONArray arr= new JSONArray();
        JSONObject binding = new JSONObject();
        JSONObject placedetail= new JSONObject();

        String placeid= AssertionExmp.placeid;
        placedetail.put("place_id",placeid);
        placedetail.put("address","updated");
        placedetail.put("key","qaclick123");

        System.out.println(arr);

        FileWriter writer = new FileWriter("C:\\Energy Components\\EC-12_1_workspace\\RestTest\\src\\main\\resources\\update.json");
        writer.write(placedetail.toString());
        writer.flush();
    }

}
