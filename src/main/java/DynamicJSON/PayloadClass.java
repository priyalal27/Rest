package DynamicJSON;

public class PayloadClass {

    public String AddBook(String isbn, String aisle){
        String payload="{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";

        return payload;
    }


    public String DeleteBook(String ID){
        String payload="{\"ID\":\""+ID+"\"}";
        return payload;
    }

}
