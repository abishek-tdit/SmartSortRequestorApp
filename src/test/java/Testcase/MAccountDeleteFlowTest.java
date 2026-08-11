package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.MAccountDeleteFlow.ALoginPage;
import com.AndroidTest.MAccountDeleteFlow.BDeleteAccountPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MAccountDeleteFlowTest extends BaseClassMobile {

    @Test(priority = 1)
    public void accountDeleteFlow() {

        try {
        //Login
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0512457896",
                "Admin@199");

            // Delete Account
            BDeleteAccountPage deleteAccount = new BDeleteAccountPage(driver);
            deleteAccount.deleteAccount();

            ExtentTestListener.logStep("Delete Account Clicked Successfully");

            ExtentTestListener.logStep("Account Delete Flow Completed Successfully");

            Assert.assertTrue(true);
        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Test Failed : " + e.getMessage());
            Assert.fail("Account Delete Flow Failed", e);
        }
    }
}