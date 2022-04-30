package Activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity3 extends screenshot {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws Exception{

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceID","RZ8RA1FGFDK");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        URL remoteUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<>(remoteUrl,caps);

    }
    @Test
    public void additionTest()
    {
        MobileElement digit5= driver.findElementById("calc_keypad_btn_05");
        digit5.click();
        driver.findElementById("calc_keypad_btn_add").click();
        MobileElement digit9= driver.findElementById("calc_keypad_btn_09");
        digit9.click();
        //driver.findElementById("calc_keypad_btn_equal").click();

        String resultText=driver.findElementById("calc_tv_result").getText();
        System.out.println(resultText);
        assertEquals(resultText,"14");
    }
    @Test
    public void SubtractionTest()
    {

        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_sub").click();
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_equal").click();

        String resultText=driver.findElementById("calc_edt_formula").getText();
        System.out.println(resultText);
        assertEquals(resultText,"5");
    }
    @Test
    public void MultiplyTest()
    {

        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementByAccessibilityId("Multiplication").click();
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_equal").click();

        String resultText=driver.findElementById("calc_edt_formula").getText();
        System.out.println(resultText);
        assertEquals(resultText,"500");
    }

    @Test
    public void DivisionTest()
    {

        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementByXPath("//android.widget.Button[@content-desc=\"Division\"]").click();
        driver.findElementById("calc_keypad_btn_02").click();
        driver.findElementById("calc_keypad_btn_equal").click();

        String resultText=driver.findElementById("calc_edt_formula").getText();
        System.out.println(resultText);
        assertEquals(resultText,"25");
    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
