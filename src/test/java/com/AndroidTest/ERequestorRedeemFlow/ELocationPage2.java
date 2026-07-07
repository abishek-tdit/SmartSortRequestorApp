package com.AndroidTest.ERequestorRedeemFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ELocationPage2 {

    AndroidDriver driver;
    WebDriverWait wait;

    public ELocationPage2(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void selectLocation2() throws Exception {

        // WAIT HOME PAGE LOAD
        Thread.sleep(10000);


        // Explore Other Locations Button
        WebElement exploreBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Explore Other Locations")
                )
        );


        // Click Button
        exploreBtn.click();

        System.out.println("Explore Other Locations clicked");


        // Wait After Explore Other Locations Click
        Thread.sleep(5000);


        // SELECT LOCATION - Bqaiq
        WebElement locationBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Bqaiq")
                )
        );

        locationBtn.click();

        System.out.println("Bqaiq location selected");


        // Wait After Location Selection
        Thread.sleep(8000);
    }
}
