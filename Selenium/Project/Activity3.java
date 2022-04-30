package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup()
    {
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void activity3()
    {
        WebElement userName= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        WebElement btnLogin= driver.findElement(By.id("btnLogin"));
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        btnLogin.click();

        String welcomeText=driver.findElement(By.id("welcome")).getText();

        if(welcomeText.contains("Welcome"))
        {
            System.out.println("homepage has opened");
        }
        else
        {
            System.out.println("homepage has not opened");
        }

    }


    @AfterMethod
    public void teardown()
    {
        driver.close();
    }

}

