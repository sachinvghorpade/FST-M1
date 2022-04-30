package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class Project_Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws Exception{

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceID","RZ8RA1FGFDK");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
        caps.setCapability("noReset",true);

        URL remoteUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<>(remoteUrl,caps);
        wait = new WebDriverWait(driver, 10);

        // Open page
        driver.get("https://www.training-support.net/selenium");

    }
    @Test
    public void addToDoList() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));

        // Scroll element into view and click it
        driver.findElement(
                        MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"To-Do List\"))"))
                .click();

        // Wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.Button")));
        driver.findElementByClassName("android.widget.EditText").sendKeys("Add tasks to list");
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button").click();

        driver.findElementByClassName("android.widget.EditText").sendKeys("Get number of tasks");
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button").click();

        driver.findElementByClassName("android.widget.EditText").sendKeys("Clear the list");
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button").click();

        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TextView").click();
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView").click();
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.TextView").click();

        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]").click();





    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}


