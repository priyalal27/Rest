package AssertionExample;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {

public String readProperties() throws IOException {


    Properties prop= new Properties();
    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
    InputStream input = classLoader.getResourceAsStream("URL.properties");
    prop.load(input);

    String baseuri=prop.getProperty("AssertionExmp_baseuri");

    return baseuri;
}
}
