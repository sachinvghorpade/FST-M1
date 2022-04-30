package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

        WebDriver driver;
        WebDriverWait wait;

        @BeforeMethod
        public void setup()
        {
            driver= new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/orangehrm");
        }

        @Test
        public void activity2()
        {
            WebElement element= driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png']"));
            System.out.println("test");
            String imageUrl= element.getAttribute("src");
            System.out.println(imageUrl);
        }

        @AfterMethod
        public void teardown()
        {
            driver.close();
        }

    }

