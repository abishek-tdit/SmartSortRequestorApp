package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.C4CollectionCenterAcceptOrderFlow.ALoginPage;
import com.AndroidTest.C4CollectionCenterAcceptOrderFlow.BUnacceptedOrdersPage;
import com.AndroidTest.C4CollectionCenterAcceptOrderFlow.CLogoutPage;
import org.testng.annotations.Test;

public class C4CollectionCenterAcceptOrderFlowTest extends BaseClassMobile {

    @Test(priority = 6)
    public void collectionCenterAcceptOrderFlowTest() throws Exception {

        //TTFVaasan : 0500123001

        //Login:
        ALoginPage loginPage = new ALoginPage();
        loginPage.login("0500123001",
                "Admin@194");

        //Unaccepted - Orders:
        BUnacceptedOrdersPage unacceptedOrdersPage = new BUnacceptedOrdersPage();
        unacceptedOrdersPage.clickUnacceptedOrders();
        unacceptedOrdersPage.clickOrder();
        unacceptedOrdersPage.swipeToAccept();
        unacceptedOrdersPage.clickOkPopup();

        ExtentTestListener.logStep("Accept Order Flow Completed");

        //Logout Page:
        CLogoutPage logoutPage = new CLogoutPage(driver);
        logoutPage.logout();

        ExtentTestListener.logStep("Collection center  Order 2nd  Flow Completed Successfully");
    }
}