package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BHomePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public BHomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickProfileIcon() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                                "/android.widget.FrameLayout/android.widget.FrameLayout" +
                                "/android.view.View/android.view.View/android.view.View" +
                                "/android.view.View/android.view.View[1]" +
                                "/android.view.View/android.widget.ImageView[1]"
                )
        )).click();

        System.out.println("Profile Icon Clicked");

        Thread.sleep(3000);
    }
}