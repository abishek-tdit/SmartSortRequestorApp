package Testcase;

import Base.ExtentTestListener;
import com.AndroidTest.GRequestorOrderCancellingFlow.ALoginPage;
import com.AndroidTest.GRequestorOrderCancellingFlow.BLocationPage;
import com.AndroidTest.GRequestorOrderCancellingFlow.CCancelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GRequestorOrderCancellingFlowTest extends ExtentTestListener {

    @Test
    public void cancelFlowTest() {

        try {

            // LOGIN
//            ALoginPage loginPage = new ALoginPage(driver);
//            loginPage.login(
//                    "0500000055",
//                    "Admin@194");
            Thread.sleep(5000);

            //=========================================================
            // LOCATION
            //=========================================================

            BLocationPage locationPage = new BLocationPage(driver);
            locationPage.selectLocation();
            Thread.sleep(4000);

            //=========================================================
            // CANCEL FLOW
            //=========================================================

            CCancelPage cancelPage = new CCancelPage(driver);

            cancelPage.openPendingOrders();

            //=========================================================
            // Change Order Number Before Execution
            //=========================================================

            cancelPage.selectOrderToCancel("AB-RO-62055");

            //=========================================================
            // Cancel Order
            //=========================================================

            cancelPage.clickCancelButton();
            cancelPage.selectCancelReason();
            cancelPage.clickSubmit();
            cancelPage.clickOkPopup();

            ExtentTestListener.logStep(
                    "Cancel Flow Completed Successfully");

        } catch (Exception e) {

            e.printStackTrace();

            takeScreenshot("CancelFlow");

            Assert.fail(
                    "Cancel Flow Failed : " + e.getMessage()
            );
        }
    }
}