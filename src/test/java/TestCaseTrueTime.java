import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCaseTrueTime {
    private AppiumDriver<MobileElement> driver;

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
        TouchAction action = new TouchAction(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        MobileElement eleStart = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Get Started']"));
        eleStart.click();
        MobileElement eleAccept = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Accept']"));
        eleAccept.click();
        MobileElement eleSkip = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Skip This Step']"));
        eleSkip.click();

        MobileElement iconHamburger = driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@displayed='true'])[1]/.."));
        iconHamburger.click();
        iconHamburger.click();
//        driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView)[1]")).click();
//        if (!hamburgerIcon.isDisplayed()){
//            throw new Error("Hamburger icon is not displayed");
//        }else{
//            System.out.println("Hamburger");
//        }
//        hamburgerIcon.click();

        MobileElement xButton = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='\uE14C']/.."));
        MobileElement home = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='HOME']/.."));
        MobileElement whatBal = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[contains(@text, 'a BAL TrueTime?')]/.."));
        MobileElement upgradeBal = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='UPGRADE TO BAL TrueTime']/.."));
        MobileElement immigrationNews = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Immigration News']/.."));
        MobileElement privatePolicy = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Privacy Policy']/.."));
        MobileElement termAndConditions = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bal.approvaltime:id/action_bar_root']//android.widget.ScrollView)[1]//android.widget.TextView[@text='Terms & Conditions']/.."));
        MobileElement caseLabel = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='CASES']"));
//        MobileElement upgradeBalLabel = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Benefits of upgrading to BAL TrueTime']"));
//        MobileElement Url = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']"));
//        MobileElement buttonOnce = driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button_once']"));



        ArrayList<String> error1 = new ArrayList<String>();
        ArrayList<String> error2 = new ArrayList<String>();

        if (!xButton.isDisplayed()) {
            error1.add("X button not displayed");
        }
        if (!home.isDisplayed()) {
            error1.add("Home option is not display");
        }
        if (!whatBal.isDisplayed()) {
            error1.add("WHAT'S a BAL TrueTime? is not display");
        }
        if (!upgradeBal.isDisplayed()) {
            error1.add("UPGRADE TO BAL TrueTime is not display");
        }
        if (!immigrationNews.isDisplayed()) {
            error1.add("Immigration News is not display");
        }
        if (!privatePolicy.isDisplayed()) {
            error1.add("Privacy Policy is not display");
        }
        if (!termAndConditions.isDisplayed()) {
            error1.add("Terms & Conditions is not display");
        }

        if (error1.size() > 0){
            error1.forEach(System.out::println);
            throw new Error("Menu option displayed not correctly");
        }

        home.click();
        if (!caseLabel.isDisplayed()){
            error2.add("Case list page is not displayed");
        }
        iconHamburger.click();
        iconHamburger.click();

        whatBal.click();
        whatBal.click();
        MobileElement whatBalLabel = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Why did BAL create Case TrueTime?']"));
        if (!whatBalLabel.isDisplayed()){
            error2.add("Information of WHAT'S a BAL TrueTime? is not displayed");
        }
        iconHamburger.click();
        iconHamburger.click();

//
//        upgradeBal.click();
//        if (!upgradeBalLabel.isDisplayed()){
//            error2.add("UPGRADE TO BAL TrueTime is not displayed");
//        }
//        iconHamburger.click();
//
//        immigrationNews.click();
//        if (!Url.getText().equals("balglobal.com/news-US/")){
//            error2.add("Url of Immigration News is not matched");
//        }
//        driver.navigate().back();
//
//        privatePolicy.click();
//        if (!Url.getText().equals("balglobal.com/terms-of-use-and-privacy-policy/")){
//            error2.add("Url of Private Policy is not matched");
//        }
//        driver.navigate().back();
//
//        termAndConditions.click();
//        if (!Url.getText().equals("balglobal.com/digitalterms/")){
//            error2.add("Url of Term and Conditions is not matched");
//        }
//        driver.navigate().back();
//
//        xButton.click();
//        if (xButton.isDisplayed()){
//            error2.add("Menu is not closed successfully");
//        }
//
//        if (error2.size() > 0){
//            error2.forEach(System.out::println);
//        }
    }
}


