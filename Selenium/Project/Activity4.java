package Activities;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setup()
    {
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }




    @Test
    public void activity4()
    {
        WebElement userName= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        WebElement btnLogin= driver.findElement(By.id("btnLogin"));
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        btnLogin.click();
        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Employee List")).click();
        driver.findElement(By.id("btnAdd")).click();

        String firstName= RandomString.make(8);
        String lastName= RandomString.make(8);
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.linkText("Employee List")).click();

        WebElement searchbox= driver.findElement(By.id("empsearch_employee_name_empName"));
        searchbox.clear();
        searchbox.sendKeys(firstName+" "+lastName);
        driver.findElement(By.id("searchBtn")).click();

        String fn = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
        String ln= driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
        System.out.println("First Name:"+fn+" LastName:"+ln);

if(firstName.equalsIgnoreCase(fn) && lastName.equalsIgnoreCase(ln))
{
    System.out.println("Employee is created and verified.");
}
else
{
    System.out.println("Employee name is not created");
}

    }
    @AfterMethod
    public void teardown()
    {
        //driver.close();
    }

}
