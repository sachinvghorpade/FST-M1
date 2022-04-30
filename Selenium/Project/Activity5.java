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

public class Activity5 {
    WebDriver driver;



    @BeforeMethod
    public void setup()
    {
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }


    @Test
    public void activity5() throws InterruptedException {
        WebElement userName= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        WebElement btnLogin= driver.findElement(By.id("btnLogin"));
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        btnLogin.click();
        Thread.sleep(2000);
       WebElement myinfo=driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
       myinfo.click();
       Thread.sleep(2000);
        driver.findElement(By.id("btnSave")).click();

        String firstName= "John";
        String lastName= "Doe";
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys(firstName);
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(lastName);
        driver.findElement(By.id("personal_optGender_1")).click();
        WebElement NationalityDropDown= driver.findElement(By.id("personal_cmbNation"));
        Select sel= new Select(NationalityDropDown);
        sel.selectByVisibleText("Indian");
        driver.findElement(By.id("btnSave")).click();

    }
    @AfterMethod
    public void teardown()
    {
        driver.close();
    }

}
