package Scripts;

import Functions.CallDriver;
import Functions.CommonFunctions;
import Functions.VerificationFunctions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
    public void run(String url) throws InterruptedException {
        ////enter to URL
        commonFunctions.urlAddress(url);
        //navigate to calculator page
        commonFunctions.navigateToCalulator();
        verificationFunctions.verifyMessage();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }





}
