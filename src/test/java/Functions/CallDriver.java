package Functions;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class CallDriver {

    public static WebDriver driver;
    private static String systemOS = System.getProperty("os.name").toLowerCase();
    private static String path = System.getProperty("user.dir");

    public static WebDriver chrome(){//(String url){
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setHeadless(true);
        setChromedriverInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

 
    private static void setChromedriverInstance() {
        if (systemOS.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver-windows.exe");
        } else if (systemOS.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver-mac");
        } else {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver-linux");
        }
    }

} 
