import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestAppSauceLab {
    @Rule
    public TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };
    private AppiumDriver<MobileElement> driver;

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }


    @Before
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("appiumVersion", "1.20.2");
//        capabilities.setCapability("idleTimeout", "90");
//        capabilities.setCapability("noReset", "true");
//        capabilities.setCapability("newCommandTimeout", "90");
//        capabilities.setCapability("language", "en");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("name", name.getMethodName());
        capabilities.setCapability("appPackage", "com.bal.cobalt");
        capabilities.setCapability("automationName", "UiAutomator2");
        //You need to upload your own Native Mobile App to Sauce Storage!
        //https://wiki.saucelabs.com/display/DOCS/Uploading+your+Application+to+Sauce+Storage
        capabilities.setCapability("app", "storage:filename=BALCobalt_v3.1.apk");

        driver = new AndroidDriver<MobileElement>(
                new URL("https://zatagi:5999ed91-5673-4a90-bc1f-f1def37c0b14@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
                capabilities);
    }

    @After
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    @Test
    public void shouldOpenApp() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView)[1]")).click();
        getDriver().findElement(By.xpath("//android.view.View[@resource-id='root']//android.view.View//android.widget.EditText[1]")).sendKeys("regr_beneficiary");
        getDriver().findElement(By.xpath("//android.view.View[@resource-id='root']//android.view.View//android.widget.EditText[2]")).sendKeys("IMS@regr#test215");
        getDriver().findElement(By.xpath("//android.view.View[@resource-id='root']//android.view.View//android.widget.Button")).click();
        boolean MyAction = getDriver().findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='My Actions']")).isDisplayed();
    }
}
