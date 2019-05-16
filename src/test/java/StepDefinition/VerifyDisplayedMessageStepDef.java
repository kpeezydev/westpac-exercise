package StepDefinition;

import Functions.CallDriver;
import Functions.CommonFunctions;
import Functions.VerificationFunctions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;


public class VerifyDisplayedMessageStepDef {
    private WebDriver driver;
    private CommonFunctions commonFunctions;
    private VerificationFunctions verificationFunctions;

    @Before
    public void setup() {
        driver= CallDriver.chrome();
        commonFunctions = new CommonFunctions(driver);
        verificationFunctions = new VerificationFunctions(driver);
    }

    @Given("^user is on calculator page$")
    public void user_is_on_calculator_page() {
        commonFunctions.urlAddress("https://www.westpac.co.nz/");
        //navigate to calculator page
        commonFunctions.navigateToCalulator();

    }

    @When("^user clicks on help icon for the age field$")
    public void user_clicks_on_help_icon_for_the_age_field() {
        commonFunctions.clickCurrentAgeInfo();

    }

    @Then("^user should see the help text$")
    public void user_should_see_the_help_text()  {
        verificationFunctions.verifyDisplayedMessage();

    }


    @After
    public void closeBrowser(){
        driver.quit();
    }

}
