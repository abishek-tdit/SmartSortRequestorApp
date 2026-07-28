package com.AndroidTest.ESmartBotTicketManagementFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BSmartBotPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public BSmartBotPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openSmartBotAndStartChat() throws InterruptedException {


        // Click SmartBot Icon
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]"
                ))).click();

        System.out.println("Clicked SmartBot");

        Thread.sleep(4000);


        // Click Start New Chat
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Start new chat")
        )).click();

        System.out.println("Clicked Start New Chat");

        Thread.sleep(5000);
    }
}