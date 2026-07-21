package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.MOrderDetailsFlow.ALoginPage;
import com.AndroidTest.MOrderDetailsFlow.BOrderDetailsPage;
import org.testng.annotations.Test;

public class MOrderDetailsFlowTest extends BaseClassMobile {

    @Test public void testOrderDetailsFlow() throws Exception {

        //Abishek rtr      - 0500098765 Dom (RO)
        //Jamuna           - 0500445566 Dom (NON RO)

        //Login:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500445566",
//                "Admin@194");
//
//         ExtentTestListener.logStep("Login completed");

        //Order Details Page:
        BOrderDetailsPage orderPage = new BOrderDetailsPage(driver);
        orderPage.openTab("Pending");
        orderPage.validateAllOrders("Pending", 5);
        orderPage.openTab("Completed");
        orderPage.validateAllOrders("Completed", 5);
        orderPage.openTab("Rescheduled");
        orderPage.validateAllOrders("Rescheduled", 5);
        orderPage.openTab("Cancelled");
        orderPage.validateAllOrders("Cancelled", 5);

        ExtentTestListener.logStep("ALL TABS VALIDATED");
        driver.navigate().back();
    }
}