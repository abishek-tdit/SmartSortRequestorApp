package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.MOrderDetailsFlow.ALoginPage;
import com.AndroidTest.MOrderDetailsFlow.BOrderDetailsPage;
import org.testng.annotations.Test;

public class MOrderDetailsFlowTest extends BaseClassMobile {

    @Test(priority = 9)
    public void testOrderDetailsFlow() throws Exception {

        //Abiram abi      - 0500000055 Dom

        //Login:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500000055",
//                "Admin@194");
//
//         ExtentTestListener.logStep("Login completed");

        //Order Details Page:
        Thread.sleep(5000);
        BOrderDetailsPage orderPage = new BOrderDetailsPage(driver);
        orderPage.openTab("Pending");
        Thread.sleep(2000);
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