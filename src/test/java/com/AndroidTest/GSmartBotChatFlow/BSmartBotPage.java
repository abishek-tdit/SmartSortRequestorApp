package com.AndroidTest.GSmartBotChatFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

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

    private final By smartBotIcon =
            AppiumBy.xpath(
                    "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                            "/android.widget.FrameLayout" +
                            "/android.widget.FrameLayout" +
                            "/android.view.View" +
                            "/android.view.View" +
                            "/android.view.View[2]" +
                            "/android.widget.ImageView"
            );

    private final By startNewChat =
            AppiumBy.accessibilityId("Start new chat");

    //=========================================================
    // Open SmartBot
    //=========================================================

    public void openSmartBot() {

        log("========== OPEN SMARTBOT ==========");

        click(smartBotIcon);

        log("Clicked SmartBot Icon");

        waitVisible(startNewChat);

        log("SmartBot Screen Opened");
    }

    //=========================================================
    // Start New Chat
    //=========================================================

    public void startNewChat() {

        click(startNewChat);

        log("Clicked Start New Chat");

        delay(2);
    }

    //=========================================================
    // Combined Method
    //=========================================================

    public void openSmartBotAndStartChat() {

        openSmartBot();

        startNewChat();

        log("New Chat Started Successfully");
    }

}