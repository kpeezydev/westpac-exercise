package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonObjects  {


    public CommonObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[text()='KiwiSaver']")
    public WebElement kiwiSaver;

    @FindBy(xpath="//a[text()='KiwiSaver calculators']")
    public WebElement kiwiSaverCalc;

    @FindBy(xpath="//a[text()='Click here to get started.']")
    public WebElement getStarted;

    @FindBy(xpath="//label[text()='Current age']//following::i[1]")
    public WebElement currentAgeInfo;

    @FindBy(xpath="//p[text()='This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.']")
    public WebElement currentAgeMsg;

    @FindBy(xpath="//iframe[contains(@src,'calculator-widgets/kiwisaver-calculator')]")
    public WebElement frameCalcu;

    @FindBy(xpath="//label[text()='Current age']//following::input[1]")
    public WebElement currentAgeInput;

    @FindBy(xpath="//label[text()='Employment status']//following::i[1]")
    public WebElement employmentStatusInput;

    @FindBy(xpath="//label[contains(text(),'Voluntary')]//following::i[1]")
    public WebElement voluntaryContributionTermsInput;

    @FindBy(xpath="//label[contains(text(),'Salary')]//following::input[1]")
    public WebElement salaryInput;

    @FindBy(xpath="//label[contains(text(),'(PIR)')]//following::i[1]")
    public WebElement investorRateInput;

    @FindBy(xpath="//button//span[text()='View your KiwiSaver retirement projections']")
    public WebElement calculateBtn;

    @FindBy(xpath="//span[@class='result-value result-currency ng-binding']")
    public WebElement calculationResult;

    @FindBy(xpath="//label[contains(text(),'Voluntary')]//following::input[1]")
    public WebElement volumtaryContribution;

    @FindBy(xpath="//label[contains(text(),'KiwiSaver balance')]//following::input[1]")
    public WebElement kiwiSaverBal;

    @FindBy(xpath="//label[contains(text(),'Savings goal')]//following::input[1]")
    public WebElement savingsGoal;

    @FindBy(xpath="//div[@id='graph']")
    public WebElement graph;

    public WebElement employmentStatus(WebDriver driver, String employmentStatusVal) {
        return driver.findElement(By.xpath("//li//span[text()='"+employmentStatusVal+"']"));
    }

    public WebElement investorRate(WebDriver driver, String investorRateVal) {
        return driver.findElement(By.xpath("//li//span[text()='"+investorRateVal+"%']"));
    }

    public WebElement voluntaryContributionTerms(WebDriver driver, String voluntaryContributionTermsVal) {
        return driver.findElement(By.xpath("//li//span[text()='"+voluntaryContributionTermsVal+"']"));
    }

    public WebElement contribution(WebDriver driver, String contibutionVal) {
        return driver.findElement(By.xpath("//span[text()='"+contibutionVal+"%']//preceding::input[1]"));
    }

    public WebElement risk(WebDriver driver, String riskVal) {
        return driver.findElement(By.xpath("//span[text()='"+riskVal+"']//preceding::input[1]"));
    }















}
