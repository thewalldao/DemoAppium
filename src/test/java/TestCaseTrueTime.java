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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCaseTrueTime {
    private AndroidDriver<MobileElement> driver;
    public boolean isMenuOpen = false;

    public void tabByElement(MobileElement element) {
        new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
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

    public boolean isMenuOpen(){
        MobileElement menulabel = driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@displayed='true'])[1]"));
        if (menulabel.getText().equals('\uE14C')){
            return true;
        }else {
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
//        capabilities.setCapability("noReset", true);
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
            driver.closeApp();
            driver.quit();
        }
    }

    @Test
    public void shouldOpenApp() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement eleStart = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Get Started']"));
        waitAndClickElementInsecond(eleStart, 1);

        MobileElement eleAccept = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Accept']"));
        waitAndClickElementInsecond(eleAccept,1);

        MobileElement eleSkip = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Skip This Step']"));
        waitAndClickElementInsecond(eleSkip,1);

        MobileElement buttonMenu = driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@displayed='true'])[1]/.."));
        boolean isKeyboardShown = driver.isKeyboardShown();
        if (!isKeyboardShown) {
            buttonMenu.click();
        }

        MobileElement buttonHome = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='HOME']/.."));
        MobileElement buttonWhatBal = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[contains(@text, 'a BAL TrueTime?')]"));
        MobileElement buttonUpgradeBal = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='UPGRADE TO BAL TrueTime']/.."));
        MobileElement linkImmigrationNews = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Immigration News']/.."));
        MobileElement linkPrivatePolicy = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Privacy Policy']/.."));
        MobileElement linkTermAndConditions = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Terms & Conditions']/.."));
        MobileElement labelCase = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='CASES']"));


        ArrayList<String> inAppErrors = new ArrayList<String>();
        ArrayList<String> inWebviewErrors = new ArrayList<String>();

        if (isMenuOpen() && !buttonMenu.isDisplayed()) {
            inAppErrors.add("X button not displayed");
        }
        if (!buttonHome.isDisplayed()) {
            inAppErrors.add("Home option is not display");
        }
        if (!buttonWhatBal.isDisplayed()) {
            inAppErrors.add("WHAT'S a BAL TrueTime? is not display");
        }
        if (!buttonUpgradeBal.isDisplayed()) {
            inAppErrors.add("UPGRADE TO BAL TrueTime is not display");
        }
        if (!linkImmigrationNews.isDisplayed()) {
            inAppErrors.add("Immigration News is not display");
        }
        if (!linkPrivatePolicy.isDisplayed()) {
            inAppErrors.add("Privacy Policy is not display");
        }
        if (!linkTermAndConditions.isDisplayed()) {
            inAppErrors.add("Terms & Conditions is not display");
        }

        if (inAppErrors.size() > 0) {
            inAppErrors.forEach(System.out::println);
            throw new Error("Menu option displayed not correctly");
        }


        waitAndClickElementInsecond(buttonHome, 1);
        if (!labelCase.isDisplayed()) {
            inWebviewErrors.add("Case list page is not displayed");
        }
        pressByElementWithSecond(buttonMenu, 1);
        tabByElement(buttonMenu);


        waitAndClickElementInsecond(buttonWhatBal, 1);
        MobileElement buttonWhatBalLabel = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Why did BAL create Case TrueTime?']"));
        if (!buttonWhatBalLabel.isDisplayed()) {
            inWebviewErrors.add("Information of WHAT'S a BAL TrueTime? is not displayed");
        }
        waitAndClickElementInsecond(buttonMenu, 1);


        waitAndClickElementInsecond(buttonUpgradeBal, 1);
        MobileElement buttonUpgradeBalLabel = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Benefits of upgrading to BAL TrueTime']"));
        if (!buttonUpgradeBalLabel.isDisplayed()) {
            inWebviewErrors.add("UPGRADE TO BAL TrueTime is not displayed");
        }
        driver.navigate().back();
        waitAndClickElementInsecond(buttonMenu, 1);


        waitAndClickElementInsecond(linkImmigrationNews, 1);
        MobileElement Url = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']"));
        if (!Url.getText().equals("balglobal.com/news-US/")) {
            inWebviewErrors.add("Url of Immigration News is not matched");
        }
        driver.navigate().back();


        linkPrivatePolicy.click();
        MobileElement linkPrivatePolicyUrl = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']"));
        if (!linkPrivatePolicyUrl.getText().equals("balglobal.com/terms-of-use-and-privacy-policy/")) {
            inWebviewErrors.add("Url of Private Policy is not matched");
        }
        driver.navigate().back();


        linkTermAndConditions.click();
        MobileElement linkTermAndConditionsUrl = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']"));
        if (!linkTermAndConditionsUrl.getText().equals("balglobal.com/digitalterms/")) {
            inWebviewErrors.add("Url of Term and Conditions is not matched");
        }
        driver.navigate().back();


        waitAndClickElementInsecond(buttonMenu, 1);
        if (isMenuOpen()) {
            inWebviewErrors.add("Menu is not closed successfully");
        }


        if (inWebviewErrors.size() > 0) {
            inWebviewErrors.forEach(System.out::println);
        }
    }
}


