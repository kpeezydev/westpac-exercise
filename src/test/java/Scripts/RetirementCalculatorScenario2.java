package Scripts;

import Functions.CallDriver;
import Functions.CommonFunctions;
import Functions.VerificationFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RetirementCalculatorScenario2 {

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
    @Parameters({"url", "age", "employeeStatusVal", "investorRateVal", "kiwiSaverBal", "contributionAmount", "voluntaryContributionTermsVal", "riskVal", "savingsGoalVal"})

    public void run(ITestContext testContext, String url, String age, String employeeStatusVal, String investorRateVal, String kiwiSaverBal, String contributionAmount, String voluntaryContributionTermsVal, String riskVal, String savingsGoalVal ) {

        //enter to URL
        commonFunctions.urlAddress(url);
        //navigate to calculator page
        commonFunctions.navigateToCalulator();
        //wait to load
        commonFunctions.sleep();
        //input scenario details
        commonFunctions.currentAgeInput(age);
        commonFunctions.employmentStatusInput(employeeStatusVal);
        commonFunctions.investorRateInput(investorRateVal);
        commonFunctions.kiwiSaverBal(kiwiSaverBal);
        commonFunctions.volumtaryContributionInput(contributionAmount);
        commonFunctions.voluntaryContributionTermsInput(voluntaryContributionTermsVal);
        commonFunctions.riskInput(riskVal);
        commonFunctions.savingsGoal(savingsGoalVal);
        //calculate
        commonFunctions.clickCalculate();
        //get calculation result
        verificationFunctions.compareEstimateSavingsGoal(savingsGoalVal);
        //take screenshot
        commonFunctions.graphScreenShot(testContext.getName());

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
