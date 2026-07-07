package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.BSmartSortRegistrationArabicFlow.ASignUpArabicPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BSmartSortRegistrationArabicFlowTest extends BaseClassMobile {

    @Test(priority = 1)
    public void registrationArabicFlow() {

        try {

            System.out.println("Arabic Registration Flow Started");

            //Arabic Sign Up
            ASignUpArabicPage signUpPage = new ASignUpArabicPage(driver);
            signUpPage.signUp();

            System.out.println("Arabic Registration Flow Completed Successfully");

            Assert.assertTrue(true,"Arabic Registration completed successfully");
        }
        catch (Exception e) {

            e.printStackTrace();

            Assert.fail("Arabic Registration Flow Failed : " + e.getMessage());
        }
    }
}