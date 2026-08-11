package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.C7CollectionCenterDirectDeliveryOrderFlow.ADirectQuantityOrdersPage;
import com.AndroidTest.C7CollectionCenterDirectDeliveryOrderFlow.BCompleteOrder;
import com.AndroidTest.C7CollectionCenterDirectDeliveryOrderFlow.CLogoutPage;
import org.testng.annotations.Test;

public class C7CollectionCenterDirectDeliveryOrderFlowTest extends BaseClassMobile {

    @Test(priority = 9)
    public void GCollectionCenterDirectDeliveryOrderFlow() throws Exception {

        //Direct - Order:
        ADirectQuantityOrdersPage ordersPage = new ADirectQuantityOrdersPage();
        ordersPage.clickDirectQuantityOrders();
        ordersPage.clickRecentOrder();
        ordersPage.clickProceedToComplete();
        ordersPage.clickProceedOrder();
        ordersPage.enterAluminiumKg("10");

        //Complete - Order:
        BCompleteOrder completeOrder = new BCompleteOrder();
        completeOrder.clickSubmit();
        completeOrder.clickProceed();
        completeOrder.clickOkPopup();

        //Logout:
        CLogoutPage logoutPage = new CLogoutPage(driver);
        logoutPage.logout();

        ExtentTestListener.logStep("Collection Center Direct Delivery Order Flow Completed");
    }
}