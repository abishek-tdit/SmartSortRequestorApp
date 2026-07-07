package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.MOrderDetailsFlow.ALoginPage;
import com.AndroidTest.MOrderDetailsFlow.BOrderDetailsPage;
import org.testng.annotations.Test;

public class MOrderDetailsFlowTest extends BaseClassMobile {

    @Test
    public void testOrderDetailsFlow() throws Exception {

        //.Abishek DS      - 0500098765 Dom
        //.Krishna Kumar   - 0500003576 Corp

        //LOGIN
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login();
        System.out.println("Login completed");

        //Order Details
        BOrderDetailsPage orderPage = new BOrderDetailsPage(driver);
        //Pending
        orderPage.openTab("Pending");
        orderPage.validateAllOrders("Pending", 5);
        //Completed
        orderPage.openTab("Completed");
        orderPage.validateAllOrders("Completed", 5);
        //Rescheduled
        orderPage.openTab("Rescheduled");
        orderPage.validateAllOrders("Rescheduled", 5);
        //Cancelled (optional)
        orderPage.openTab("Cancelled");
        orderPage.validateAllOrders("Cancelled", 5);

        System.out.println("ALL TABS VALIDATED");
        driver.navigate().back();
    }
}

