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

public class RetirementCalculatorScenario1 {

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
    @Parameters({"url", "age", "employeeStatusVal", "salary", "contributionVal", "riskVal", "investorRateVal"})
    public void run(ITestContext testContext, String url, String age, String employeeStatusVal, String salary, String contributionVal, String riskVal, String investorRateVal )
    {
        //enter to URL
        commonFunctions.urlAddress(url);
        //navigate to calculator page
        commonFunctions.navigateToCalulator();
        //input scenario details
        commonFunctions.currentAgeInput(age);
        commonFunctions.employmentStatusInput(employeeStatusVal);
        commonFunctions.salaryInput(salary);
        commonFunctions.contributionInput(contributionVal);
        commonFunctions.riskInput(riskVal);
        commonFunctions.investorRateInput(investorRateVal);
        //calculate
        commonFunctions.clickCalculate();
        //get calculation result
        verificationFunctions.verifyComputation();
        commonFunctions.graphScreenShot(testContext.getName());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
