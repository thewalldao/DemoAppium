import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ultility {
    private AppiumDriver<MobileElement> driver;

    public void waitElementDisplayed(String xpathLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 120);
            WebElement clickOK = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.Button[@text='OK']")));
        }catch(Exception e){
            System.out.println((e));
        }
    }

}
