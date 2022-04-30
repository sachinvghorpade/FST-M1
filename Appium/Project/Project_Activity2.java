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

public class Project_Activity2 {
         AndroidDriver<MobileElement> driver;

        @BeforeClass
        public void setup() throws Exception{

            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability("deviceID","RZ8RA1FGFDK");
            caps.setCapability("platformName","android");
            caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("appPackage","com.google.android.keep");
            caps.setCapability("appActivity",".activities.BrowseActivity");
            caps.setCapability("noReset",true);

            URL remoteUrl=new URL("http://localhost:4723/wd/hub");
            driver=new AndroidDriver<>(remoteUrl,caps);

        }
        @Test
        public void addNote()  {
            driver.findElementById("new_note_button").click();

            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
            driver.findElementById("editable_title").sendKeys("Title is added");
            driver.findElementById("edit_note_text").sendKeys("note has been added");

            driver.findElementByAccessibilityId("Navigate up").click();
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_title")));
            String noteTitle= driver.findElementById("index_note_title").getText();
            Assert.assertEquals(noteTitle,"Title is added");



        }

        @AfterClass
        public void teardown()
        {
            driver.quit();
        }
    }


