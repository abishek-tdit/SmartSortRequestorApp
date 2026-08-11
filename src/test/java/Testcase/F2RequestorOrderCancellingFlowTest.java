package Testcase;

import Base.ExtentTestListener;
import Utility.COrderDataCancel;
import com.AndroidTest.F2RequestorOrderCancellingFlow.BLocationPage;
import com.AndroidTest.F2RequestorOrderCancellingFlow.CCancelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class F2RequestorOrderCancellingFlowTest extends ExtentTestListener {

    @Test(priority = 14)
    public void cancelFlowTest() {

        try {

            //=========================================================
            // LOCATION
            //=========================================================

            BLocationPage locationPage = new BLocationPage(driver);
            locationPage.selectLocation();

            //=========================================================
            // CANCEL FLOW
            //=========================================================

            CCancelPage cancelPage = new CCancelPage(driver);

            // Open Orders
            cancelPage.openOrders();

            // Select Saved Order
            cancelPage.selectOrderToCancel(
                    COrderDataCancel.orderNumberCancel);

            // Cancel Order
            cancelPage.clickCancelButton();
            cancelPage.selectCancelReason();
            cancelPage.clickSubmit();
            cancelPage.clickOkPopup();

            ExtentTestListener.logStep(
                    "Requestor Order Cancellation Flow Completed Successfully");

        } catch (Exception e) {

            e.printStackTrace();

            takeScreenshot("F2RequestorOrderCancellingFlow");

            Assert.fail(
                    "Requestor Order Cancellation Flow Failed : "
                            + e.getMessage());
        }
    }
}