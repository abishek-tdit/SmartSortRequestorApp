package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.LOrderDetailsFlow.BOrderDetailsPage;
import org.testng.annotations.Test;

public class LOrderDetailsFlowTest extends BaseClassMobile {

    @Test(priority = 9)
    public void testOrderDetailsFlow() throws Exception {

        Thread.sleep(5000);

        BOrderDetailsPage orderPage =
                new BOrderDetailsPage(driver);

        orderPage.openTab("Pending");
        orderPage.validateAllOrders("Pending", 5);

        orderPage.openTab("Completed");
        orderPage.validateAllOrders("Completed", 5);

        orderPage.openTab("Rescheduled");
        orderPage.validateAllOrders("Rescheduled", 5);

        orderPage.openTab("Cancelled");
        orderPage.validateAllOrders("Cancelled", 5);

        ExtentTestListener.logStep(
                "ALL TABS VALIDATED"
        );

        driver.navigate().back();
    }
}