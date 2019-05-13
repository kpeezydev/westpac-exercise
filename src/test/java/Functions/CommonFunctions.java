package Functions;

import Objects.CommonObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class CommonFunctions extends DriverBaseClass {

    private CommonObjects commonObj = new CommonObjects(driver);

    public CommonFunctions(WebDriver driver) {
        super(driver);
    }

    public void urlAddress(String url) {
        driver.get(url);
    }

    Actions action = new Actions(driver);


    public void navigateToCalulator() {

        action.moveToElement(commonObj.kiwiSaver).perform();
        commonObj.kiwiSaverCalc.click();
        commonObj.getStarted.click();
    }

    public void closeBrowser() {

        driver.quit();
    }

    public void currentAgeInput(String age) {
        driver.switchTo().frame(commonObj.frameCalcu);
        commonObj.currentAgeInput.sendKeys(age);
        System.out.println("========== age: " + age + " ==========");
    }

    public void employmentStatusInput(String employmentStatusVal) {
        action.moveToElement(commonObj.employmentStatusInput).click().build().perform();
        commonObj.employmentStatus(driver, employmentStatusVal).click();
        System.out.println("========== employment status: " + employmentStatusVal + " ==========");
    }

    public void investorRateInput(String investorRateVal) {
        action.moveToElement(commonObj.investorRateInput).click().build().perform();
        commonObj.investorRate(driver, investorRateVal).click();
        System.out.println("========== Prescribed investor rate (PIR): " + investorRateVal + "% ==========");
    }

    public void volumtaryContributionInput(String contributionAmount) {
        commonObj.volumtaryContribution.sendKeys(contributionAmount);
        System.out.println("========== Voluntary contribution: " + contributionAmount + " ==========");
    }

    public void kiwiSaverBal(String kiwiSaverBal) {
        commonObj.kiwiSaverBal.sendKeys(kiwiSaverBal);
        System.out.println("========== Current Kiwi Saver Balance: " + kiwiSaverBal + " ==========");
    }

    public void voluntaryContributionTermsInput(String voluntaryContributionTermsVal) {
        action.moveToElement(commonObj.voluntaryContributionTermsInput).click().build().perform();
        commonObj.voluntaryContributionTerms(driver, voluntaryContributionTermsVal).click();
        System.out.println("========== Contribution amount: " + voluntaryContributionTermsVal + " ==========");
    }

    public void salaryInput(String salary) {
        commonObj.salaryInput.sendKeys(salary);
        System.out.println("========== salary: " + salary + " ==========");
    }

    public void contributionInput(String contributionVal) {
        commonObj.contribution(driver, contributionVal).click();
        System.out.println("========== KiwiSaver member contribution: " + contributionVal + "% ==========");
    }

    public void riskInput(String riskVal) {
        commonObj.risk(driver, riskVal).click();
        System.out.println("========== Risk Profile: " + riskVal + " ==========");
    }

    public void savingsGoal(String savingsGoalVal) {
        commonObj.savingsGoal.sendKeys(savingsGoalVal);
        System.out.println("========== Savings goal at retirement: " + savingsGoalVal + " ==========");
    }


    public void clickCalculate() {
        commonObj.calculateBtn.click();
        System.out.println("========== Calculating......... ==========");
    }

    public void graphScreenShot(String testName)  {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", commonObj.graph);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        screenShot("graphresults", testName);
    }


    public void screenShot(String saveFolder, String testName)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String filePath = System.getProperty("user.dir")+"\\"+saveFolder+"\\"+testName+"_"+timeStamp+".jpg";
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(filePath));               //1000 milliseconds is one second.
        } catch(IOException ex) {
            System.out.println(" File not saved! ");
        }
        String msg = "screenshot taken and saved at: "+filePath;
        System.out.println(msg);
        Reporter.log(msg);
    }


    public void pause(long seconds){

        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}

