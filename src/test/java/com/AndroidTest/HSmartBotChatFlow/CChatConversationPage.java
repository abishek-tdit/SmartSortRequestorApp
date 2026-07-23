package com.AndroidTest.HSmartBotChatFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CChatConversationPage extends BasePage {
    // Constructor
    public CChatConversationPage(AndroidDriver driver) {
        super(driver);
    }

    // Locators
    private final By messageBox =
            AppiumBy.className("android.widget.EditText");
    private final By sendButton =
            AppiumBy.xpath("//android.view.View[@content-desc='Smart Bot']/android.view.View[5]");
    private final By closeButton =
            AppiumBy.xpath("//android.view.View[@content-desc='Smart Bot']/android.view.View[3]");

    // Ask Question
    public void askQuestion(String question) {

        log("========== SMARTBOT QUESTION ==========");

        // Enter Question
        sendKeys(messageBox, question);

        log("Question Entered : " + question);

        // Click Send Button
        click(sendButton);

        log("Clicked Send Button");

        // Wait for Bot Reply
        String botReply = waitForBotResponse();

        System.out.println("=================================");
        System.out.println("SMART BOT RESPONSE:");
        System.out.println(botReply);
        System.out.println("=================================");
        log("Bot Response Received Successfully");
    }

    // Wait Bot Response
    public String waitForBotResponse() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(90));
        try {
            // Wait until Thinking disappears
            wait.until(driver -> {

                List<WebElement> thinking =
                        driver.findElements(
                                AppiumBy.xpath("//*[@content-desc='Thinking...']"));
                return thinking.isEmpty();

            });

            ExtentTestListener.logStep(
                    "Bot finished thinking");

            // Get Bot Response Text
            WebElement response = wait.until(driver -> {
                List<WebElement> messages =
                        driver.findElements(
                                AppiumBy.xpath(
                                        "//android.view.View[@text and not(@text='Where is my collector?')]"
                                ));

                for (WebElement msg : messages) {
                    String text = msg.getText();
                    if (text != null &&
                            !text.trim().isEmpty()) {
                        return msg;
                    }
                }
                return null;
            });
            String botReply = response.getText();
            return botReply;
        } catch (Exception e) {
            System.out.println(
                    "Bot response not received");
            throw e;
        }
    }

    // Close SmartBot
    public void closeSmartBot() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement close =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(closeButton));
            close.click();
            ExtentTestListener.logStep(
                    "SmartBot Closed Successfully");

            System.out.println(
                    "SmartBot Closed Successfully");

        } catch (Exception e) {
            System.out.println(
                    "Unable to close SmartBot");
            throw e;
        }
    }
}