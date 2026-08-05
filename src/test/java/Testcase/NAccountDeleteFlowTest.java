
package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.MAccountDeleteFlow.ADeleteAccountPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NAccountDeleteFlowTest extends BaseClassMobile {

    @Test(priority = 1)
    public void accountDeleteFlow() {

        try {

            // Delete Account
            ADeleteAccountPage deleteAccount = new ADeleteAccountPage(driver);
            deleteAccount.deleteAccount();

            ExtentTestListener.logStep("Delete Account Clicked Successfully");

            ExtentTestListener.logStep("Account Delete Flow Completed Successfully");

            Assert.assertTrue(true);

        } catch (Exception e) {

            ExtentTestListener.logStep("Test Failed : " + e.getMessage());

            Assert.fail("Account Delete Flow Failed", e);
        }
    }
}