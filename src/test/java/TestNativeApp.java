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
import java.util.concurrent.TimeUnit;

public class TestNativeApp {
    private AppiumDriver<MobileElement> driver;
    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
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
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "MI 8");
        capabilities.setCapability("name", "Verify that Bal login successfully");
        capabilities.setCapability("appPackage", "com.bal.cobalt");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.bal.cobalt.MainActivity");
        capabilities.setCapability("noReset", true);
        //You need to upload your own Native Mobile App to Sauce Storage!
        //https://wiki.saucelabs.com/display/DOCS/Uploading+your+Application+to+Sauce+Storage
//            capabilities.setCapability("app", "storage:filename=BALCobalt_v3.1.apk");

        driver = new AndroidDriver<MobileElement>(
                new URL("http://192.168.170.74:4723/wd/hub"),
                capabilities);
    }

    @AfterTest
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    @Test
    public void shouldOpenApp() {
        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView)[1]")).click();
        getDriver().findElement(By.xpath("//android.view.View[@resource-id='root']//android.view.View//android.widget.EditText[1]")).sendKeys("regr_beneficiary");
        getDriver().findElement(By.xpath("//android.view.View[@resource-id='root']//android.view.View//android.widget.EditText[2]")).sendKeys("IMS@regr#test215");
        getDriver().findElement(By.xpath("//android.view.View[@resource-id='root']//android.view.View//android.widget.Button")).click();
        boolean MyAction = getDriver().findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='My Actions']")).isDisplayed();
    }
}


