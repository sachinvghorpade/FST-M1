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

public class Activity8 {
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
    public void activity8()
    {
        WebElement userName= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        WebElement btnLogin= driver.findElement(By.id("btnLogin"));
        wait=new WebDriverWait(driver,20);
        userName.sendKeys("orange");
        password.sendKeys("orangepassword123");
        btnLogin.click();
        driver.findElement(By.linkText("Dashboard")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
        driver.findElement(By.linkText("Apply")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtLeaveType")));

        WebElement leaveType= driver.findElement(By.id("applyleave_txtLeaveType"));

        Select sel= new Select(leaveType);
        sel.selectByVisibleText("DayOff");

        String leaveFromDate="2022-05-02";
        String leaveToDate="2022-05-06";
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(leaveFromDate);
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys(leaveToDate);

        driver.findElement(By.id("applyBtn")).click();

        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        driver.findElement(By.id("calFromDate")).clear();
        driver.findElement(By.id("calFromDate")).sendKeys(leaveFromDate);
        driver.findElement(By.id("calToDate")).clear();
        driver.findElement(By.id("calToDate")).sendKeys(leaveToDate);
        driver.findElement(By.id("btnSearch")).click();

        String statusText=driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).getText();
         if(statusText.contains("Pending Approval"))
        {
            System.out.println("Pending approval status found.");
        }
        else
        {
            System.out.println("Correct Status not found");
        }

    }
    @AfterMethod
    public void teardown()
    {
       driver.close();
    }

}
