package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.C3CollectorUtilityOrderCompleteFlow.*;
import com.AndroidTest.C3CollectorUtilityOrderCompleteFlow.BRequestOrderROPage1;
import com.AndroidTest.C3CollectorUtilityOrderCompleteFlow.ERequestOrderROPage2;
import org.testng.annotations.Test;

public class C3CollectorUtilityOrderCompleteFlowTest extends BaseClassMobile {

    @Test(priority = 3)
    public void collectorUtilityOrderCompleteFlow() throws Exception {

        //=========================================================
        // Launch SS Utility App
        //=========================================================

        driver.activateApp("com.smartsort.utilities");
        ExtentTestListener.logStep("SS Utility App Launched Successfully");

        //Rahul  : 0500055447
        //TDIT   : 0500000654

        //Login:
        ALoginPage loginPage = new ALoginPage();
        loginPage.login("0500055447",
                "Admin@194");

        // Open Request Order
        BRequestOrderROPage1 requestOrderPage = new BRequestOrderROPage1();
        requestOrderPage.openLatestRequestOrder();

        //Navigation Flow:
        CNavigationPage navigationPage = new CNavigationPage();
        navigationPage.completeNavigation();

        // Pickup Verification
        DPickupOTPVerificationPage pickupVerificationPage =
                new DPickupOTPVerificationPage();

        pickupVerificationPage.verifyPickup();

        //Order Completion:
        ERequestOrderROPage2 orderCompletionPage = new ERequestOrderROPage2();
        orderCompletionPage.completeOrder();

        //Material Image:
        FUploadPackedMaterialsImagePage imageUploadPage = new FUploadPackedMaterialsImagePage();
        imageUploadPage.uploadImage();

        //Assign Order:
        GDeliveryOrderAssignToCollectionCenterPage deliveryOrderPage = new GDeliveryOrderAssignToCollectionCenterPage(driver);
        deliveryOrderPage.openRequestOrdersAndRODO();

        //Logout Page:
        HLogoutPage logoutPage = new HLogoutPage(driver);
        logoutPage.clearStorage();

        ExtentTestListener.logStep("Collector  Order 1st  Flow Completed Successfully");
    }
}