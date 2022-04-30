package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup()
    {
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void activity1()
    {
        String actualPageTitle= driver.getTitle();
        System.out.println(actualPageTitle);
        String expectedPageTitle="OrangeHRM";
        if(expectedPageTitle.equalsIgnoreCase(actualPageTitle))
        {
            driver.close();
        }
        else
        {
            System.out.println("Page title is not matching.");
        }
    }

    @AfterMethod
    public void teardown()
    {
       System.out.println("Activity 1 finished.");
    }

}
