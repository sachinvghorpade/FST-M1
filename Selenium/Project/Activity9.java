package Activities;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setup()
    {
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();
    }

    @Test
    public void activity9() throws InterruptedException {
        WebElement userName = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        wait = new WebDriverWait(driver, 20);
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        btnLogin.click();
        WebElement myinfo = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
        Thread.sleep(2000);
        myinfo.click();

        driver.findElement(By.linkText("Emergency Contacts")).click();




        // Get all the table row elements from the table
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='emgcontact_list']//tr"));
       // List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='emgcontact_list']//th"));

        // And iterate over them and get all the cells
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("th"));

            // Print the contents of each cell
            for (WebElement cell : cells) {

                System.out.print(cell.getText()+" ");

                //Or try below code
                //System.out.println(cell.getAttribute("innerHTML"));
            }


        }

// And iterate over them and get all the cells
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
             // Print the contents of each cell
            for (WebElement cell : cells) {

                System.out.print(cell.getText()+"   ");

                //Or try below code
                //System.out.println(cell.getAttribute("innerHTML"));
            }
            System.out.println("");
            System.out.println("-----------------------------------------------------");
        }
    }
    @AfterMethod
    public void teardown()
    {
        driver.close();
    }

}
