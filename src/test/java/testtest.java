import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class testtest {
    private AppiumDriver<MobileElement> driver;
    public AndroidDriver<MobileElement> Adriver;
    public WebDriver Wedriver;


    public void tabByElement(MobileElement element) {
        new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }

    public void waitAndClickforClickable(By by, long timeOut) {
        WebElement wait = new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public boolean waitforDisplayed(By by, long timeOut) {
        try {
            WebElement wait = new WebDriverWait(driver, timeOut)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


//    public void waitAndTapEmlement(MobileElement element, long timetoWait){
//        Stopwatch1 timer1 = new Stopwatch1();
//        long count = 0;
//        System.out.println(++count);
//        while (timer1.getTimeLeftInSecond(timetoWait) <= 0){
//            tabByElement(element);
//            System.out.println(++count);
//            break;
//        }
//    }

    public boolean isMenuOpen() {
        MobileElement menulabel = driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@displayed='true'])[1]"));
        if (menulabel.getText().equals('\uE14C')) {
            return true;
        } else {
            return false;
        }
    }

    public void pressByElementWithSecond(MobileElement element, long duration) {
        new TouchAction(driver).longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(element))
                .withDuration(Duration.ofSeconds(duration)))
                .release()
                .perform();
    }

    public void waitAndClickElementInsecond(MobileElement element, long timeOut) {
        Stopwatch1 timer1 = new Stopwatch1();
        boolean elementIsNotDisPlayed = true;
        while (elementIsNotDisPlayed && (timer1.getTimeLeftInSecond(timeOut) >= 0)) {
            if (element.isDisplayed()) {
                element.click();
                elementIsNotDisPlayed = false;
            }
        }
    }

    public void waitAndTapElementInsecond(MobileElement element, long timeOut) {
        Stopwatch1 timer1 = new Stopwatch1();
        boolean elementIsNotDisPlayed = true;
        while (elementIsNotDisPlayed && (timer1.getTimeLeftInSecond(timeOut) >= 0)) {
            if (element.isDisplayed()) {
                tabByElement(element);
                elementIsNotDisPlayed = false;
            }
        }
    }

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
//        capabilities.setCapability("deviceName", "Nokia 5.1 Plus");
        capabilities.setCapability("name", "US6808 - Verify the Navigation of the matches the style guide - TestRail");
        capabilities.setCapability("appPackage", "com.bal.cobalt");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.bal.cobalt.MainActivity");
//        capabilities.setCapability("noReset", true);
        //You need to upload your own Native Mobile App to Sauce Storage!
        //https://wiki.saucelabs.com/display/DOCS/Uploading+your+Application+to+Sauce+Storage
//            capabilities.setCapability("app", "storage:filename=BALCobalt_v3.1.apk");

        driver = new AndroidDriver<MobileElement>(
                new URL("http://192.168.170.205:4723/wd/hub"),
                capabilities);
        Adriver = ((AndroidDriver) driver);
        Wedriver = ((WebDriver) driver);

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
//        Adriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
            driver.terminateApp("com.bal.cobalt");
            Adriver.terminateApp("com.bal.cobalt");

//            driver.closeApp();
            driver.quit();
        }
    }

    @Test
    public void shouldOpenApp() {
//        By webView = By.xpath("//android.webkit.WebView");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView)[1]")).click();
        driver.findElement(By.xpath("//android.view.View[@resource-id='root']//android.view.View//android.widget.EditText[1]")).sendKeys("regr_beneficiary");
//        System.out.println(Adriver.getCurrentPackage());
//        System.out.println(Adriver.currentActivity());
////        System.out.println(Adriver.c);
//        System.out.println(driver.getContext());
//        Set<String> availableContexts = driver.getContextHandles();
//        for (String context : availableContexts) {
//            if (context.contains("WEBVIEW")) {
//                System.out.println("Context Name is " + context);
//            }
//        }

//        System.out.println(driver.getPageSource());
        System.out.println(((JavascriptExecutor) Adriver).executeScript("return navigator.userAgent;"));
//        String user_agent = Wedriver.("return navigator.userAgent;");

    }
}


