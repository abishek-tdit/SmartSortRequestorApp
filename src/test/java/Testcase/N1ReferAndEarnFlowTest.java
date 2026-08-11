package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import Utility.MobileUtility;
import com.AndroidTest.N1ReferAndEarnFlow.*;
import org.testng.annotations.Test;

public class N1ReferAndEarnFlowTest extends BaseClassMobile {

    @Test(priority = 1)
    public void testReferAndEarnFlow() throws Exception {


        // Location
        A1LocationPage locationPage = new A1LocationPage(driver);
        locationPage.selectLocation();

        // Page Objects
        A2ReferAndEarnPage referPage = new A2ReferAndEarnPage(driver);
        BLogoutPage logoutPage = new BLogoutPage(driver);
        CASignUpPage signUpPage = new CASignUpPage(driver);

        // ================= REFER & EARN =================

        referPage.clickReferAndEarn();
        ExtentTestListener.getTest().info("Clicking Refer & Earn");
        referPage.clickReferAndEarn();
        ExtentTestListener.getTest().pass("Refer & Earn opened successfully");

        Thread.sleep(1000);

        ExtentTestListener.getTest().info("Clicking Tap to Copy");
        referPage.clickTapToCopy();
        ExtentTestListener.getTest().pass("Referral code copied successfully");

        Thread.sleep(1000);

        ExtentTestListener.getTest().info("Navigating Back");
        referPage.navigateBack();
        ExtentTestListener.getTest().pass("Returned to Home Screen");

        Thread.sleep(1000);

        // ================= LOGOUT =================

        ExtentTestListener.getTest().info("Logging out");
        logoutPage.logout();
        ExtentTestListener.getTest().pass("Logout completed successfully");

        Thread.sleep(3000);

        // ================= SIGN UP =================

        ExtentTestListener.getTest().info("Starting Sign Up Flow");
        signUpPage.signUp();
        ExtentTestListener.getTest().pass("Sign Up completed successfully");

        Thread.sleep(3000);

        // Login with newly registered user
        DLoginPage loginPage = new DLoginPage(driver);

        loginPage.login(
                MobileUtility.generatedMobileNumber,
                MobileUtility.generatedPassword );
        Thread.sleep(5000);

        // ================= DOOR PICKUP FLOW =================
        Thread.sleep(5000);
        EDoorPickupPage doorPickupPage = new EDoorPickupPage(driver);

        ExtentTestListener.getTest().info("Starting Door Pickup Flow");

        doorPickupPage.completeDoorPickupFlow();

        ExtentTestListener.getTest().pass("Door Pickup Flow Completed Successfully");


    }
}