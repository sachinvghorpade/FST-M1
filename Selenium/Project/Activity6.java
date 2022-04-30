package Activities;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;



    @BeforeMethod
    public void setup()
    {
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }


    @Test
    public void activity6() throws InterruptedException {
        WebElement userName= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        WebElement btnLogin= driver.findElement(By.id("btnLogin"));
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        btnLogin.click();

        WebElement Directory=driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
        Assert.assertTrue(Directory.isDisplayed());
        System.out.println(Directory.isDisplayed());
       WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(Directory));

        Thread.sleep(2000);
        Directory.click();

       String expectedText="Search Directory";
       String actualText=driver.findElement(By.xpath("//h1[contains(text(),'Search Directory')]")).getText();
        Assert.assertEquals(actualText,expectedText);
    }
    @AfterMethod
    public void teardown()
    {
        driver.close();
    }

}
