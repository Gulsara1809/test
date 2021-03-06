import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest5 {
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\g_kuatkhan\\Desktop\\JavaAppiumAutomation2\\apks\\org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testFirst1 () {
        waitForElementByXpathAndClick(
                "//*[@text='Search Wikipedia']",
                "Cannot find search input",
                5
        );
        waitForElementByXpathAndSendKeys(
                "//*[@text='Search…']",
                "Astana",
                "Cannot find search input",
                5
        );


        waitForElementPresentByXpath(
                "//*[@resource-id='org.wikipedia:id/search_container']",
                "Cannot find search input1",
                5

        );

    waitForElementByXpathAndClick (

            "//*[@resource-id='org.wikipedia:id/search_container']//*[@resource-id='org.wikipedia:id/search_close_btn']",
            "Cannot find search input2",
            5

    );
        waitForElementNotPresent (
                "//*[@resource-id='org.wikipedia:id/search_close_btn']",
                "Cannot find search input2",
                5

        );
}




    private WebElement waitForElementPresent(String xpath, String error_message,long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        By by = By.xpath(xpath);
        return wait.withMessage(error_message + "\n").until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementByXpathAndClick (String locator, String error_message,long timeoutInSeconds){
        WebElement element = this.waitForElementPresent(locator,error_message,timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementByXpathAndClear (String locator, String error_message,long timeoutInSeconds) {
        WebElement element = this.waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
        private WebElement waitForElementPresentByXpath (String locator, String error_message,long timeoutInSeconds){
            WebElement element = this.waitForElementPresent(locator,error_message,timeoutInSeconds);
            element.clear();
            return element;
    }


    private WebElement waitForElementByXpathAndSendKeys (String locator,String value, String error_message,long timeoutInSeconds){
        WebElement element = this.waitForElementByXpathAndClear(locator,error_message,timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }
    private boolean waitForElementNotPresent (String id, String error_message,long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        By by = By.id(id);
        return wait.withMessage(error_message + "\n").until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
