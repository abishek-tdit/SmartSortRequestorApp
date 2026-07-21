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

            //Abishek rtr      - 0500098765 Dom (RO)
            //Jamuna           - 0500445566 Dom (NON RO)

            //LOGIN:
//            ALoginPage loginPage = new ALoginPage(driver);
//            loginPage.login("0500445566",
//                         "Admin@194");
//            Thread.sleep(3000);
//            //LOCATION:
//            BLocationPage locationPage = new BLocationPage(driver);
//            locationPage.selectLocation();
            Thread.sleep(3000);

            //CANCEL:
            CCancelPage cancelPage = new CCancelPage(driver);
            cancelPage.openPendingOrders();
//================================================================================//
//================================================================================//
                      // Change order no before RUN:
            cancelPage.selectOrderToCancel("AB-RO-62003");
//================================================================================//
//================================================================================//
            cancelPage.clickCancelButton();
            cancelPage.selectCancelReason();
            cancelPage.clickSubmit();
            cancelPage.clickOkPopup();
            ExtentTestListener.logStep("Cancel Flow Login → Location → Pending Order Completed Successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            takeScreenshot("cancelFlow_LoginLocation");
            Assert.fail("Cancel Flow (Login + Location) Failed : " + e.getMessage());
        }
    }
}