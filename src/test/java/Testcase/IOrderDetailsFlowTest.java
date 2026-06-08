package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.IOrderDetailsFlow.ALoginPage;
import com.AndroidTest.IOrderDetailsFlow.BOrderDetailsPage;
import org.testng.annotations.Test;

public class IOrderDetailsFlowTest extends BaseClassMobile {

    @Test
    public void testOrderDetailsFlow() throws Exception {

        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login();
        System.out.println("✅ Login completed");

        BOrderDetailsPage orderPage = new BOrderDetailsPage(driver);

        // ✅ Pending
        orderPage.openTab("Pending");
        orderPage.validateAllOrders("Pending", 5);


        // ✅ Completed
        orderPage.openTab("Completed");
        orderPage.validateAllOrders("Completed", 5);


        // ✅ Rescheduled
        orderPage.openTab("Rescheduled");
        orderPage.validateAllOrders("Rescheduled", 5);


        // ✅ Cancelled (optional)
        orderPage.openTab("Cancelled");
        orderPage.validateAllOrders("Cancelled", 5);


        System.out.println("✅ ALL TABS VALIDATED ✅");
    }
}

