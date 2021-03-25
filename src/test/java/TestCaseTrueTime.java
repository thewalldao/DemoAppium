import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCaseTrueTime {

    private AppiumDriver<MobileElement> driver;
    public AndroidDriver<MobileElement> Adriver;


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
        capabilities.setCapability("appPackage", "com.bal.approvaltime");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.bal.approvaltime.MainActivity");
//        capabilities.setCapability("setWebContentsDebuggingEnabled", "true");
        capabilities.setCapability("chromedriverExecutable", "E:\\TUANDAO\\PROJECT\\chromedriver_win32\\chromedriver.exe");
//        capabilities.setCapability("noReset", true);
        //You need to upload your own Native Mobile App to Sauce Storage!
        //https://wiki.saucelabs.com/display/DOCS/Uploading+your+Application+to+Sauce+Storage
//            capabilities.setCapability("app", "storage:filename=BALCobalt_v3.1.apk");

        driver = new AndroidDriver<MobileElement>(
                new URL("http://192.168.170.205:4723/wd/hub"),
                capabilities);
        Adriver = ((AndroidDriver) driver);

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
//        Adriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
            driver.terminateApp("com.bal.approvaltime");
            Adriver.terminateApp("com.bal.approvaltime");

//            driver.closeApp();
            driver.quit();
        }
    }

    @Test
    public void shouldOpenApp() {


//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        long timeWaitForElement = 10;

        By eleStart = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Get Started']");
        waitAndClickforClickable(eleStart, 15);
//        waitAndClickElementInsecond(eleStart,1);
//        waitAndTapElementInsecond(eleStart.get(0),1);
//        pressByElementWithSecond(eleStart.get(0),1);
//        waitAndClickElementInsecond(eleStart, 1);

        By eleAccept = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Accept']");
        waitAndClickforClickable(eleAccept, timeWaitForElement);
//        pressByElementWithSecond(eleAccept, 1);
//        waitAndClickElementInsecond(eleAccept,1);


        By eleSkip = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Skip This Step']");
        waitAndClickforClickable(eleSkip, timeWaitForElement);

        By buttonMenu = By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@displayed='true'])[1]/..");
        boolean isKeyboardShown = Adriver.isKeyboardShown();
        if (!isKeyboardShown) {
            waitAndClickforClickable(buttonMenu, timeWaitForElement);
        }

//        By buttonHome = By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='HOME']/..");
//        By buttonWhatBal = By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[contains(@text, 'a BAL TrueTime?')]/..");
//        By buttonUpgradeBal = By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='UPGRADE TO BAL TrueTime']/..");
        By linkImmigrationNews = By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Immigration News']/..");
//        By linkPrivatePolicy = By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Privacy Policy']/..");
//        By linkTermAndConditions = By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Terms & Conditions']/..");
//        By labelCase = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='CASES']");
        By Url = By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']");
//        By buttonUpgradeBalLabel = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Benefits of upgrading to BAL TrueTime']");
//        By buttonWhatBalLabel = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Why did BAL create Case TrueTime?']");
        By webView = By.className("android.webkit.WebView");
//

//        ArrayList<String> inAppErrors = new ArrayList<String>();
        ArrayList<String> inWebviewErrors = new ArrayList<String>();
//
//        if (isMenuOpen() && !waitforDisplayed(buttonMenu,timeWaitForElement)) {
//            inAppErrors.add("X button not displayed");
//        }
//        if (!waitforDisplayed(buttonHome,timeWaitForElement)) {
//            inAppErrors.add("Home option is not display");
//        }
//        if (!waitforDisplayed(buttonWhatBal,timeWaitForElement)) {
//            inAppErrors.add("WHAT'S a BAL TrueTime? is not display");
//        }
//        if (!waitforDisplayed(buttonUpgradeBal,timeWaitForElement)) {
//            inAppErrors.add("UPGRADE TO BAL TrueTime is not display");
//        }
//        if (!waitforDisplayed(linkImmigrationNews,timeWaitForElement)) {
//            inAppErrors.add("Immigration News is not display");
//        }
//        if (!waitforDisplayed(linkPrivatePolicy,timeWaitForElement)) {
//            inAppErrors.add("Privacy Policy is not display");
//        }
//        if (!waitforDisplayed(linkTermAndConditions,timeWaitForElement)) {
//            inAppErrors.add("Terms & Conditions is not display");
//        }
//
//        if (inAppErrors.size() > 0) {
//            inAppErrors.forEach(System.out::println);
//            throw new Error("Menu option displayed not correctly");
//        }
//
//
//        waitAndClickforClickable(buttonHome, timeWaitForElement);
//        if (!waitforDisplayed(labelCase, timeWaitForElement)) {
//            inWebviewErrors.add("Case list page is not displayed");
//        }
////        pressByElementWithSecond(buttonMenu, 1);
////        tabByElement(buttonMenu);
//        waitAndClickforClickable(buttonMenu, timeWaitForElement);
//
//
//        waitAndClickforClickable(buttonWhatBal, timeWaitForElement);
//        if (!waitforDisplayed(buttonWhatBalLabel, timeWaitForElement)) {
//            inWebviewErrors.add("Information of WHAT'S a BAL TrueTime? is not displayed");
//        }
//        waitAndClickforClickable(buttonMenu, timeWaitForElement);
//
//
//        waitAndClickforClickable(buttonUpgradeBal, timeWaitForElement);
//        if (!waitforDisplayed(buttonUpgradeBalLabel, timeWaitForElement)) {
//            inWebviewErrors.add("UPGRADE TO BAL TrueTime is not displayed");
//        }
//        driver.navigate().back();
//        waitAndClickforClickable(buttonMenu, timeWaitForElement);


        waitAndClickforClickable(linkImmigrationNews, timeWaitForElement);
        waitforDisplayed(Url, timeWaitForElement);
        if (!driver.findElement(Url).getText().equals("balglobal.com/news-US/")) {
            inWebviewErrors.add("Url of Immigration News is not matched");
        }
        System.out.println(waitforDisplayed(By.xpath("//android.webkit.WebView"),5));
//        System.out.println(Adriver.getCurrentPackage());
//        System.out.println(Adriver.currentActivity());
//        System.out.println(driver.getPageSource());
//        Set<String> availableContexts = driver.getContextHandles();
//        for (String context : availableContexts) {
//            if (context.contains("WEBVIEW")) {
//                System.out.println("Context Name is " + context);
//            }
//        }
//        driver.navigate().back();
//
//        waitAndClickforClickable(linkPrivatePolicy, timeWaitForElement);
//        waitforDisplayed(Url,timeWaitForElement);
//        if (!driver.findElement(Url).getText().equals("balglobal.com/terms-of-use-and-privacy-policy/")) {
//            inWebviewErrors.add("Url of Private Policy is not matched");
//        }
//        driver.navigate().back();
//
//        waitAndClickforClickable(linkTermAndConditions, timeWaitForElement);
//        waitforDisplayed(Url,timeWaitForElement);
//        if (!driver.findElement(Url).getText().equals("balglobal.com/digitalterms/")) {
//            inWebviewErrors.add("Url of Term and Conditions is not matched");
//        }
//        driver.navigate().back();
//
//
//        waitAndClickforClickable(buttonMenu, timeWaitForElement);
//        if (isMenuOpen()) {
//            inWebviewErrors.add("Menu is not closed successfully");
//        }
//
//
//        if (inWebviewErrors.size() > 0) {
//            inWebviewErrors.forEach(System.out::println);
//        }
            }
        }


