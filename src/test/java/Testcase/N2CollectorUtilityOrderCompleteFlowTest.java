package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.N2CollectorUtilityOrderCompleteFlow.*;
import org.testng.annotations.Test;

public class N2CollectorUtilityOrderCompleteFlowTest extends BaseClassMobile {

    @Test(priority = 2)
    public void collectorUtilityOrderCompleteFlow() throws Exception {

        Thread.sleep(10000);
        //=========================================================
        // Launch SS Utility App
        //=========================================================

        driver.activateApp("com.smartsort.utilities");
        ExtentTestListener.logStep("SS Utility App Launched Successfully");
        // Swiggy : 9043422841

        // Login
        ALoginPage loginPage = new ALoginPage();
        loginPage.login(
                "9043422841",
                "Admin@194"
        );

        // Open Request Order
        BRequestOrderROPage1 requestOrderPage = new BRequestOrderROPage1();
        requestOrderPage.openLatestRequestOrder();

        // Navigation Flow
        CNavigationPage navigationPage = new CNavigationPage();
        navigationPage.completeNavigation();

        // Order Completion
        ERequestOrderROPage2 orderCompletionPage =
                new ERequestOrderROPage2();
        orderCompletionPage.completeOrder();

        // Upload Material Image
        FUploadPackedMaterialsImagePage imageUploadPage =
                new FUploadPackedMaterialsImagePage();
        imageUploadPage.uploadImage();

        ExtentTestListener.logStep("Collector Order 2nd Flow Completed Successfully");
    }
}