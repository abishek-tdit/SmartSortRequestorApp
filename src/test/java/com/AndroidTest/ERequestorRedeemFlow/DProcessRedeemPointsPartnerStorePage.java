package com.AndroidTest.ERequestorRedeemFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DProcessRedeemPointsPartnerStorePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DProcessRedeemPointsPartnerStorePage(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void proceedRedeem() throws Exception {


        // CLICK PROCEED TO REDEEM POINTS
        WebElement proceedBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Proceed to Redeem Points")));

        proceedBtn.click();

        System.out.println("Proceed to Redeem Points clicked");


        // WAIT AFTER CLICK
        Thread.sleep(5000);


        // CLICK CHECKBOX
        WebElement checkBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.CheckBox")));

        checkBox.click();

        System.out.println("Checkbox selected");


        // WAIT AFTER CHECKBOX CLICK
        Thread.sleep(3000);


        // CLICK MOST POPULAR
        WebElement mostPopular = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Most Popular")));

        mostPopular.click();

        System.out.println("Most Popular clicked");


        // WAIT AFTER MOST POPULAR CLICK
        Thread.sleep(5000);


        // SEARCH BOX
        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.EditText")));

        searchBox.click();


        // ENTER AMAZON
        searchBox.sendKeys("Amazon");

        System.out.println("Amazon entered in search box");


        // WAIT AFTER ENTER
        Thread.sleep(5000);


        // CLOSE KEYBOARD
        driver.hideKeyboard();

        System.out.println("Keyboard closed");


        // WAIT AFTER KEYBOARD CLOSE
        Thread.sleep(3000);


        // GET MOBILE SCREEN SIZE
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;

        int startY = (int) (size.height * 0.80);

        int endY = (int) (size.height * 0.30);


        // MANUAL SWIPE
        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY
                ));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY
                ));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));

        System.out.println("Page scrolled manually");


        // WAIT AFTER SCROLL
        Thread.sleep(3000);


        // FIND REDEEM BUTTON
        WebElement redeemBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().description(\"Redeem\").instance(1)")));


        // CLICK USING COORDINATE TAP
        int centerX = redeemBtn.getRect().getX() + (redeemBtn.getRect().getWidth() / 2);

        int centerY = redeemBtn.getRect().getY() + (redeemBtn.getRect().getHeight() / 2);

        PointerInput tapFinger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "tapFinger"
        );

        Sequence tap = new Sequence(finger, 1);

        tap.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        centerX,
                        centerY
                ));

        tap.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        tap.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(tap));

        System.out.println("Redeem clicked successfully");


        // WAIT AFTER REDEEM CLICK
        Thread.sleep(5000);


//====================================================================================================
//For First Time Redeem process - we need to enter email ID and need to verify the OTP
//Click the popup OK btn for confirmation - after successfully verification done, its completed
//when we Redeem for 2nd time - After clicked Redeem - it will directly open the SAR Points page
//=============================================================================================

////   ENTER EMAIL
//        WebElement emailBox = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.className("android.widget.EditText")
//                )
//        );
//
//// CLEAR EXISTING TEXT
//        emailBox.clear();
//
//// ENTER EMAIL ONLY ONCE
//        emailBox.sendKeys("abishek251295@gmail.com");
//
//        System.out.println("Email entered");
//
//// WAIT AFTER EMAIL ENTER
//        Thread.sleep(3000);
//
//// CLOSE KEYBOARD
//        driver.hideKeyboard();
//
//        System.out.println("Keyboard closed");
//
//// WAIT AFTER KEYBOARD CLOSE
//        Thread.sleep(2000);
//
//// CLICK SEND OTP
//        WebElement sendOtpBtn = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.accessibilityId("Send OTP")
//                )
//        );
//
//        sendOtpBtn.click();
//
//        System.out.println("Send OTP clicked");
//
//// WAIT FOR OTP SENT POPUP
//        Thread.sleep(5000);
//
//// CLICK OK BUTTON
//        WebElement okBtn = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.accessibilityId("OK")
//                )
//        );
//
//        okBtn.click();
//
//        System.out.println("OK popup clicked");
//
//// WAIT AFTER CLICK
//        Thread.sleep(3000);
//
//        // WAIT 30 SECONDS FOR MANUAL OTP ENTRY
//        System.out.println("Waiting 30 seconds for manual OTP entry...");
//
//        Thread.sleep(30000);
//===============================================================================================


        // ENTER SAR AMOUNT
        WebElement sarAmount = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.EditText")));

        sarAmount.click();

        Thread.sleep(1000);

        sarAmount.sendKeys("10");

        System.out.println("SAR Amount entered");

        Thread.sleep(2000);


        // CLICK REDEEM GIFT BUTTON
        WebElement redeemGiftBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Redeem Gift")));

        redeemGiftBtn.click();

        System.out.println("Redeem Gift button clicked");

        Thread.sleep(5000);


        // CLICK OK POPUP BUTTON
        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")));

        okBtn.click();

        System.out.println("OK popup clicked successfully");

        Thread.sleep(3000);
    }
}