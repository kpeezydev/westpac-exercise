package Functions;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallDriver {

    public static WebDriver driver;

    public static WebDriver chrome(){//(String url){
        //String path = System.getProperty("user.dir");

        
        System.setProperty("webdriver.chrome.driver","/home/rof/src/chromedriver");
//      System.setProperty("webdriver.chrome.driver",path+"/drivers/chromedriver.exe" );
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setHeadless(true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

} 
