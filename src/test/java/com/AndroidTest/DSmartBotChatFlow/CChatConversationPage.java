package com.AndroidTest.DSmartBotChatFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CChatConversationPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CChatConversationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void askQuestion(String question) throws InterruptedException {


        // Type Question
        WebElement textBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")
                ));

        textBox.click();
        textBox.sendKeys(question);

        System.out.println("Question Entered : " + question);

        Thread.sleep(2000);


        // Click Send Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Smart Bot']/android.view.View[5]"
                )
        )).click();

        System.out.println("Send Button Clicked");


        // Wait for Bot Response
        Thread.sleep(10000);

        System.out.println("Bot Response Received");
    }
}