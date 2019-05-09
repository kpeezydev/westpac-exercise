package Functions;

import org.openqa.selenium.WebDriver;

public class DriverBaseClass {

    public static WebDriver driver;

    public DriverBaseClass(WebDriver driver){
        DriverBaseClass.driver = driver;
    }
}
