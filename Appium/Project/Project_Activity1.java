package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Project_Activity1 {
         AndroidDriver<MobileElement> driver;

        @BeforeClass
        public void setup() throws Exception{

            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability("deviceID","RZ8RA1FGFDK");
            caps.setCapability("platformName","android");
            caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("appPackage","com.google.android.apps.tasks");
            caps.setCapability("appActivity",".ui.TaskListsActivity");
            caps.setCapability("noReset",true);

            URL remoteUrl=new URL("http://localhost:4723/wd/hub");
            driver=new AndroidDriver<>(remoteUrl,caps);

        }
        @Test
        public void addTasks()  {
            driver.findElementById("tasks_fab").click();

            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
            driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
            driver.findElementById("add_task_done").click();
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
            String task3= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();
            Assert.assertEquals(task3,"Complete Activity with Google Tasks");

            driver.findElementById("tasks_fab").click();
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
            driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
            driver.findElementById("add_task_done").click();
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
            String task2= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
            Assert.assertEquals(task2,"Complete Activity with Google Keep");

            driver.findElementById("tasks_fab").click();
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
            driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
            driver.findElementById("add_task_done").click();
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
            String task1= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
            Assert.assertEquals(task1,"Complete the second Activity Google Keep");

        }

        @AfterClass
        public void teardown()
        {
            driver.quit();
        }
    }


