package com.AndroidTest.C6CollectionCenterUpdateQuantityFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BPickupQuantityOrdersPage extends BaseClassMobile {

    public void clickPickupQuantityOrders() throws InterruptedException {

        try {

            // Click Pickup Quantity Orders
            ExtentTestListener.logStep("Clicking Pickup Quantity Orders...");

            WebElement pickupQuantityOrders = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().descriptionContains(\"Pickup Quantity Orders\")")));

            pickupQuantityOrders.click();


            ExtentTestListener.logStep("Pickup Quantity Orders clicked successfully.");

            // Click First Available Order
            ExtentTestListener.logStep("Clicking First Order...");

            WebElement order = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("(//android.view.View[contains(@content-desc,'AB-DO-')])[1]")));

            order.click();


            // Click Update Quantity
            ExtentTestListener.logStep("Clicking Update Quantity...");

            WebElement updateQuantity = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Update Quantity")));

            updateQuantity.click();


            // Click KG Textbox
            WebElement weightField = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            AppiumBy.className("android.widget.EditText")
                    )
            );

            weightField.click();
            Thread.sleep(800);
            weightField.clear();
            weightField.sendKeys("10");

            ExtentTestListener.logStep("Weight entered: 10 KG");

            //Hide Keyboard
            try {
                driver.hideKeyboard();
            }
            catch (Exception ignored) {
            }


            // Click Submit
            ExtentTestListener.logStep("Clicking Submit...");

            WebElement submitButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Submit")));

            submitButton.click();


            // Click OK Popup
            ExtentTestListener.logStep("Clicking OK Popup...");

            WebElement okButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("OK")));

            okButton.click();


            ExtentTestListener.logStep("Quantity updated successfully.");

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Error while clicking Pickup Quantity Orders: " + e.getMessage());
            throw e;
        }
    }
}