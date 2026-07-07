package com.AndroidTest.ERequestorRedeemFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HVoucherPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public HVoucherPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // STEP 1: Click Explore Other Locations

    public void clickExploreLocations() {

        WebElement exploreBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Explore Other Locations")
                )
        );

        exploreBtn.click();
        System.out.println("Explore Other Locations clicked");

    }

    // STEP 2: Select Bqaiq Location
    public void selectBqaiqLocation() {

        WebElement locationBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Bqaiq")
                )
        );

        locationBtn.click();
        System.out.println("Bqaiq location selected");
    }

    // STEP 3: Custom Scroll Method
    public void scrollDown() throws InterruptedException {

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

        driver.perform(List.of(swipe));

        System.out.println("Page scrolled manually");

        Thread.sleep(3000);
    }

    // STEP 4: Click Redeem & Cash it out
    public void clickRedeemCashOut() {

        WebElement redeemBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.view.View[@content-desc=\"Redeem & cash it out\"]/android.widget.Button")
                )
        );

        redeemBtn.click();
        System.out.println("Redeem & Cash it out clicked");
    }


    //    //  Reusable Wait Method (instead of Thread.sleep directly)
//    public void waitForSeconds(int seconds) {
//        try {
//            Thread.sleep(seconds * 1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
    // STEP 5: Click Proceed to Redeem Points
    public void clickProceedToRedeemPoints() {

        WebElement proceedRedeemBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Proceed to Redeem Points")
                )
        );

        proceedRedeemBtn.click();
        System.out.println("Proceed to Redeem Points clicked");
    }


    // STEP 6: Click Voucher Option
    public void clickVoucher() {

        WebElement voucherBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Voucher")
                )
        );

        voucherBtn.click();
        System.out.println("Voucher selected");
    }


    //  STEP 7: Click Checkbox
    public void clickCheckbox() {

        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.CheckBox")
                )
        );

        checkbox.click();
        System.out.println("Checkbox selected");
    }

    public void enterPoints(String pointsValue) {

        WebElement pointsField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")
                )
        );

        pointsField.click();
        pointsField.clear();
        pointsField.sendKeys(pointsValue);

        System.out.println("Points entered: " + pointsValue);
    }

    public void hideKeyboardIfVisible() {

        try {
            driver.hideKeyboard();
            System.out.println("Keyboard hidden");
        } catch (Exception e) {
            System.out.println("Keyboard not visible");
        }
    }

    public void clickRedeemVoucher() {

        WebElement redeemVoucherBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Redeem Voucher")
                )
        );

        redeemVoucherBtn.click();
        System.out.println("Redeem Voucher clicked");
    }

    // ✅ STEP 11: Click OK Popup
    public void clickOkPopup() {

        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")
                )
        );

        okBtn.click();
        System.out.println("✅ OK popup clicked");

    }
}