package com.AndroidTest.CSmartSortRedeemFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRedeemCashOutPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CRedeemCashOutPage(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void redeemPoints() throws Exception {


        // WAIT AFTER BQAIQ LOCATION SELECTED
        Thread.sleep(5000);


        // GET MOBILE SCREEN SIZE
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;

        int startY = (int) (size.height * 0.80);

        int endY = (int) (size.height * 0.30);


        // SWIPE CODE
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, startY));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), startX, endY));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));

        System.out.println("Page scrolled manually");


        // WAIT AFTER SCROLL
        Thread.sleep(3000);


        // CLICK REDEEM BUTTON
        WebElement redeemBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.view.View[@content-desc=\"Redeem & cash it out\"]/android.widget.Button")
                )
        );

        redeemBtn.click();

        System.out.println("Redeem button clicked");
    }
}