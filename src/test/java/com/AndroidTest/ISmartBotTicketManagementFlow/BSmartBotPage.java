package com.AndroidTest.ISmartBotTicketManagementFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BSmartBotPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public BSmartBotPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By smartBotIcon = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.widget.FrameLayout" +
                    "/android.view.View/android.view.View/android.view.View" +
                    "/android.view.View/android.widget.ImageView[2]"
    );

    private final By startNewChatButton =
            AppiumBy.accessibilityId("Start new chat");

    //=========================================================
    // Open SmartBot & Start Chat
    //=========================================================

    public void openSmartBotAndStartChat() {

        wait.until(elementToBeClickable(smartBotIcon)).click();

        ExtentTestListener.logStep("Clicked SmartBot");

        wait.until(elementToBeClickable(startNewChatButton)).click();

        ExtentTestListener.logStep("Clicked Start New Chat");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("SmartBot chat started successfully");
        }
    }
}