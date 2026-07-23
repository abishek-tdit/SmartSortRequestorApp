package com.AndroidTest.ERequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CRedeemCashItOutPage1 extends BasePage {


    public CRedeemCashItOutPage1(AndroidDriver driver) {
        super(driver);
    }


    //=========================================================
    // Locator
    //=========================================================

    private final By redeemCashOutButton =
            AppiumBy.xpath(
                    "//*[@content-desc='Redeem & cash it out']"
            );


    //=========================================================
    // Redeem Points
    //=========================================================

    public void redeemPoints1() {


        log("========== REDEEM CASH OUT STARTED ==========");


        boolean isFound = false;


        // Scroll until Redeem button appears
        for(int i = 0; i < 5; i++) {


            if(!driver.findElements(redeemCashOutButton).isEmpty()) {

                isFound = true;
                log("Redeem Cash Out button found");

                break;
            }


            utility.swipeUp(0.7);

            log("Scrolling down...");
        }


        if(!isFound) {

            throw new RuntimeException(
                    "Redeem & cash it out button not found after scrolling"
            );
        }


        WebElement redeemButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                redeemCashOutButton
                        )
                );


        redeemButton.click();


        log("Clicked 'Redeem & Cash It Out'");


        log("========== REDEEM CASH OUT COMPLETED ==========");
    }
}