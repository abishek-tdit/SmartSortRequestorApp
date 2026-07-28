package com.AndroidTest.GCustomerCareServicesFlow;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.time.Duration;

public class BCallCustomerCarePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public BCallCustomerCarePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // CLICK CALL ICON
    public void clickCallIcon() {
        try {

            By callIcon = By.xpath("(//android.widget.ImageView)[7]");

            wait.until(ExpectedConditions.visibilityOfElementLocated(callIcon));

            driver.findElement(callIcon).click();

            System.out.println("Call icon clicked successfully");

        } catch (Exception e) {
            System.out.println("Failed to click call icon: " + e.getMessage());
        }
    }

    // CLICK CALL BUTTON IN POPUP
    public void clickCallButton() {
        try {

            By callButton = By.xpath("//android.widget.Button[@content-desc='Call']");

            wait.until(ExpectedConditions.elementToBeClickable(callButton));

            driver.findElement(callButton).click();

            System.out.println("Call button clicked successfully");

        } catch (Exception e) {
            System.out.println("Failed to click Call button: " + e.getMessage());
        }
    }

    //Navigate Back To HomePage
    public void navigateBackToHomePage() {
        try {

            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            Thread.sleep(2000);

            driver.pressKey(new KeyEvent(AndroidKey.BACK));

            Thread.sleep(2000);

            System.out.println("Back button pressed successfully");

        } catch (Exception e) {
            System.out.println("Failed to press back button: " + e.getMessage());
        }
    }
}