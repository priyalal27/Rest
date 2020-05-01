package OAuthExample.AuthCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebUIgetcode {

    String URL="https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss";
    static String code;

    //@BeforeTest
      public void getCodeFromUI(){
        System.setProperty("webdriver.chrome.driver", "C:\\EC_TEST_AUTOMATION\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.manage().window().maximize();


        driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("priyalal2792");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("rajklal238");
        driver.findElement(By.xpath("<span class=\"RveJvd snByac\">Next</span>")).click();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String currenturl=driver.getCurrentUrl();

        String partialurl=currenturl.split("code=")[1];
        code=partialurl.split("&scope=")[1];
    }
}
