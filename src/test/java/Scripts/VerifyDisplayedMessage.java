package Scripts;

import Functions.CallDriver;
import Functions.CommonFunctions;
import Functions.VerificationFunctions;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;


public class VerifyDisplayedMessage {

    private WebDriver driver;
    private CommonFunctions commonFunctions;
    private VerificationFunctions verificationFunctions;

    @BeforeTest
    public void setup() {
        driver= CallDriver.chrome();
        commonFunctions = new CommonFunctions(driver);
        verificationFunctions = new VerificationFunctions(driver);
    }

    @Test
    @Parameters({"url"})
    public void run(String url) {
        ////enter to URL
        commonFunctions.urlAddress(url);
        //navigate to calculator page
        commonFunctions.navigateToCalulator();
        //pause
        commonFunctions.pause(5);
        //verify message
        verificationFunctions.verifyMessage();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }





}
