package Functions;

import Objects.CommonObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.text.DecimalFormat;

public class VerificationFunctions extends DriverBaseClass {

    private CommonObjects commonObj = new CommonObjects(driver);
    private CommonFunctions commonFunctions = new CommonFunctions(driver);

    public VerificationFunctions(WebDriver driver){
        super(driver);
    }

    public void verifyMessage() throws InterruptedException {

        driver.switchTo().frame(commonObj.frameCalcu);
        commonObj.currentAgeInfo.click();
        String expectedMessage = "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.";
        System.out.println("===== expected message: "+expectedMessage+" =====");
        String message = commonObj.currentAgeMsg.getText();
        Assert.assertTrue(expectedMessage.contains(message), "message did not match");
        String msg = "========== expected message was displayed ==========";
        System.out.println(msg);
        Reporter.log(msg);

    }

    public void compareEstimateSavingsGoal(String savingsGoalVal){

        driver.switchTo().defaultContent();
        driver.switchTo().frame(commonObj.frameCalcu);
        String compValue = commonObj.calculationResult.getText().replace("$","");
        String compvalue2 = compValue.replaceAll("^\\s*","");

        long convertedCompValue =  Integer.parseInt(compvalue2.replace(",",""));
        long convertedSavingsGoalVal = Integer.parseInt(savingsGoalVal.replace(",",""));


        DecimalFormat format = new DecimalFormat("#,###.##");

        String msg1 = "========== Estimate value("+format.format(convertedCompValue)+") is less than Savings Goal("+format.format(convertedSavingsGoalVal)+") ==========";
        String msg2 = "========== Estimate value is("+format.format(convertedCompValue)+")Good job!==========";
        if(convertedCompValue < convertedSavingsGoalVal){
            System.out.println(msg1);
            Reporter.log(msg1);
        }
        else{
            System.out.println(msg2);
            Reporter.log(msg2);
        }
    }
    public void verifyComputation(){

        driver.switchTo().defaultContent();
        driver.switchTo().frame(commonObj.frameCalcu);
        String compValue = commonObj.calculationResult.getText().replace("$","");
        String msg = "========== Computation value is $"+compValue.trim()+" ==========";
        System.out.println(msg);
        Reporter.log(msg);


    }


}