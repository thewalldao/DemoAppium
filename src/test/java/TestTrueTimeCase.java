import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestTrueTimeCase {
    private AppiumDriver<MobileElement> driver;

//    public AppiumDriver<MobileElement> driver {
//        return driver;
//    }

    private String name;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("appiumVersion", "1.20.2");
//        capabilities.setCapability("idleTimeout", "90");
//        capabilities.setCapability("noReset", "true");
//        capabilities.setCapability("newCommandTimeout", "90");
//        capabilities.setCapability("language", "en");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "Nokia 5.1 Plus");
        capabilities.setCapability("name", "US6808 - Verify the Navigation of the matches the style guide - TestRail");
        capabilities.setCapability("appPackage", "com.bal.approvaltime");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.bal.approvaltime.MainActivity");
        capabilities.setCapability("noReset", true);
        //You need to upload your own Native Mobile App to Sauce Storage!
        //https://wiki.saucelabs.com/display/DOCS/Uploading+your+Application+to+Sauce+Storage
//            capabilities.setCapability("app", "storage:filename=BALCobalt_v3.1.apk");

        driver = new AndroidDriver<MobileElement>(
                new URL("http://192.168.170.205:4723/wd/hub"),
                capabilities);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldOpenApp() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Skip This Step']")).click();
        driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView)[1]")).isDisplayed();
        driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView)[1]")).click();

        MobileElement xButton = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='\uE14C']"));
        MobileElement Home = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Home']"));
        MobileElement whatBal = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='what's BALestimate?']"));
        MobileElement immigrationNews = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Immigration News']"));
        MobileElement termAndConditions = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Terms & Conditions']"));


        ArrayList<String> error = new ArrayList<String>();
        if (!xButton.isDisplayed()) {
            error.add("X button not displayed");
        }
        if (!Home.isDisplayed()) {
            error.add("Home option is not display");
        }
        if (!whatBal.isDisplayed()) {
            error.add("what's BALestimate? is not display");
        }
        if (!immigrationNews.isDisplayed()) {
            error.add("Immigration News is not display");
        }
        if (!termAndConditions.isDisplayed()) {
            error.add("Terms & Conditions is not display");
        }

        if (error.size() > 0){
            error.forEach(System.out::println);
            throw new Error("Menu option displayed not correctly");
        }


    }
}


