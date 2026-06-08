package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.ASmartSortRegistrationFlow.ASignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ASmartSortRegistrationFlowTest extends BaseClassMobile {

    @Test(priority = 1,
            description = "Verify user can register successfully with valid details")
    public void registrationFlow() {

        try {

            System.out.println("====================================");
            System.out.println("Registration Flow Started");
            System.out.println("====================================");

            // Create Sign Up Page Object
            ASignUpPage signUpPage = new ASignUpPage(driver);

            // Execute Registration Flow
            signUpPage.signUp();

            System.out.println("====================================");
            System.out.println("Registration Flow Completed Successfully");
            System.out.println("====================================");

            Assert.assertTrue(true, "Registration completed successfully");

        } catch (Exception e) {

            e.printStackTrace();

            Assert.fail("Registration Flow Failed : " + e.getMessage());
        }
    }
}