package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.N3VerifyReferralPointsFlow.ARequestorLoginPage;
import com.AndroidTest.N3VerifyReferralPointsFlow.BLocationPage;
import com.AndroidTest.N3VerifyReferralPointsFlow.CApprovedReferralUsersPage;
import org.testng.annotations.Test;

public class N3VerifyReferralPointsFlowTest extends BaseClassMobile {

    @Test(priority = 3)
    public void verifyReferralPointsFlow() throws Exception {

        //=========================================================
        // Launch SmartSort App
        //=========================================================
        driver.activateApp("com.abqaiq.smartsort");
        ExtentTestListener.logStep("Smart Sort App Launched Successfully");
        Thread.sleep(5000);


        //Logout from Requestor App
        ARequestorLoginPage requestorLoginPage = new ARequestorLoginPage(driver);

        requestorLoginPage.logoutAndLogin(
                "0500000055",
                "Admin@194");

        ExtentTestListener.logStep("Login Completed");

        //Location Page
        BLocationPage locationPage = new BLocationPage(driver);
        locationPage.selectLocation();
        Thread.sleep(8000);



        // Approved Referral Users
        CApprovedReferralUsersPage approvedReferralUsersPage =
                new CApprovedReferralUsersPage(driver);

        approvedReferralUsersPage.clickRedeemCashOut();

        ExtentTestListener.logStep("Verify Referral Points Flow Completed Successfully");
    }
}
