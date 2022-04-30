package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup()
    {
        driver= new FirefoxDriver();
        wait=new WebDriverWait(driver,20);
        Reporter.log("Test Started");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("broswer opened");
        Reporter.log("Page Title: "+driver.getTitle());


    }
    @BeforeMethod
    public void testSetup(){
        Reporter.log("Test Setup done");
     //   wait.until(ExpectedConditions.alertIsPresent());

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
        Reporter.log("closing browser");
    }
    @Test(priority = 0)
    public void simpleAlert()
    {
driver.findElement(By.id("simple")).click();
Reporter.log("Simple button clicked");
Alert simple=driver.switchTo().alert();
Reporter.log("Switch to Alert");
Reporter.log("Alert text is "+ simple.getText());
Assert.assertEquals("This is a JavaScript Alert!",simple.getText());
simple.accept();
Reporter.log("Alert Accepted");
        driver.switchTo().defaultContent();
    }
    @Test(priority = 1)

    public void confirmAlertTestCase() {

        Reporter.log("confirmAlertTestCase() started |");

        //Click the button to open a simple alert

        driver.findElement(By.id("confirm")).click();

        Reporter.log("Confirm Alert opened |");



        //Switch to alert window

        Alert confirmAlert = driver.switchTo().alert();

        Reporter.log("Switched foucs to alert |");



        //Get text in the alert box and print it

        String alertText = confirmAlert.getText();

        Reporter.log("Alert text is: " + alertText + " |");



        //Assertion

        Assert.assertEquals("This is a JavaScript Confirmation!", alertText);



        confirmAlert.accept();

        Reporter.log("Alert closed |");



        Reporter.log("Test case ended |");
        driver.switchTo().defaultContent();

    }



    @Test(priority = 2)

    public void promptAlertTestCase() {

        Reporter.log("promptAlertTestCase() started |");

        //Click the button to open a simple alert

        driver.findElement(By.id("prompt")).click();

        Reporter.log("Prompt Alert opened |");



        //Switch to alert window

        Alert promptAlert = driver.switchTo().alert();

        Reporter.log("Switched foucs to alert |");



        //Get text in the alert box and print it

        String alertText = promptAlert.getText();

        Reporter.log("Alert text is: " + alertText + " |");



        promptAlert.sendKeys("Awesome!");

        Reporter.log("Text entered in prompt alert |");



        //Assertion

        Assert.assertEquals("This is a JavaScript Prompt!", alertText);



        promptAlert.accept();

        Reporter.log("Alert closed |");



        Reporter.log("Test case ended |");
        driver.switchTo().defaultContent();

    }


}
