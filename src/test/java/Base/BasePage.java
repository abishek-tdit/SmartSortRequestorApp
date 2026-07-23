package Base;

import Utility.MobileUtility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected MobileUtility utility;

    //=========================================================
    // Constructor
    //=========================================================
    public BasePage(AndroidDriver driver) {

        this.driver = driver;
        this.wait = BaseClassMobile.wait;
        this.utility = new MobileUtility(driver);
    }

    //=========================================================
    // Click
    //=========================================================
    protected void click(By locator) {

        utility.click(locator);
    }

    //=========================================================
    // Mobile Click
    //=========================================================
    protected void mobileClick(By locator) {

        utility.mobileClick(locator);
    }

    //=========================================================
    // Send Keys
    //=========================================================
    protected void sendKeys(By locator, String value) {

        utility.sendKeys(locator, value);
    }

    //=========================================================
    // Hide Keyboard
    //=========================================================
    protected void hideKeyboard() {

        utility.hideKeyboard();
    }

    //=========================================================
    // Wait Visible
    //=========================================================
    protected void waitVisible(By locator) {

        utility.waitForVisible(locator);
    }

    //=========================================================
    // Wait Clickable
    //=========================================================
    protected void waitClickable(By locator) {

        utility.waitForClickable(locator);
    }

    //=========================================================
    // Get Visible Element
    //=========================================================
    protected WebElement getElement(By locator) {

        return utility.waitForVisible(locator);
    }

    //=========================================================
    // Get Clickable Element
    //=========================================================
    protected WebElement getClickableElement(By locator) {

        return utility.waitForClickable(locator);
    }

    //=========================================================
    // Is Displayed
    //=========================================================
    protected boolean isDisplayed(By locator) {

        try {

            return utility.waitForVisible(locator).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    //=========================================================
    // Get Text
    //=========================================================
    protected String getText(By locator) {

        return utility.waitForVisible(locator).getText();
    }

    //=========================================================
    // Clear
    //=========================================================
    protected void clear(By locator) {

        utility.waitForVisible(locator).clear();
    }

    //=========================================================
    // Delay (Keep only if absolutely needed)
    //=========================================================
    protected void delay(int seconds) {

        utility.delay(seconds);
    }

    //=========================================================
    // Log
    //=========================================================
    protected void log(String message) {

        ExtentTestListener.logStep(message);
    }

}