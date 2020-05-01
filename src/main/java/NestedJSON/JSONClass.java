package NestedJSON;

import io.restassured.path.json.JsonPath;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JSONClass {

    @Test
    public void readJSON(){
        try {
            FileReader file = new FileReader("C:\\Energy Components\\EC-12_1_workspace\\RestTest\\src\\main\\resources\\library.json");
            JSONParser parser = new JSONParser();
            String obj=parser.parse(file).toString();
            int totalsum=0;
            JsonPath jpath= new JsonPath(obj);

            //1.Print No of courses returned by API
            System.out.println(jpath.getInt("courses.size()"));

            //2.Print Purchase Amount

            String purchaseAmount=jpath.getString( "dashboard.purchaseAmount"); // Parent.Child
            System.out.println("Purchase Amount  "+purchaseAmount);

            //3. Print Title of the first course

            String firstcourse_title=jpath.getString("courses[0].title");// ParentArray[0-index number].child_field
            System.out.println("First course title "+firstcourse_title);

            // 4. Print All course titles and their respective Prices

            List courseslist=jpath.getList("courses");

            for (int i=0;i<courseslist.size();i++){
                System.out.println("courses["+i+"].title"+"   "+"courses["+i+"].price");
                //System.out.println(jpath.getString("courses["+i+"].title")+"   "+"courses["+i+"].price"));

                System.out.println(jpath.getString("courses["+i+"].title"));
                System.out.println(jpath.getString("courses["+i+"].price"));

                int price=Integer.parseInt(jpath.getString("courses["+i+"].price"));
                int copies=Integer.parseInt(jpath.getString("courses["+i+"].copies"));

                totalsum=totalsum+(price*copies);
                    if(jpath.getString("courses["+i+"].title").equals("RPA")){
                        //5.Print no of copies sold by RPA Course
                        System.out.println(jpath.getString("courses["+i+"].copies"));
                    }
                    else
                        continue;
            }


            Assert.assertEquals(Integer.parseInt(purchaseAmount),totalsum);
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }

    }

}
