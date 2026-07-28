package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.JProfileViewBasicFeaturesFlow.*;
import org.testng.annotations.Test;

public class JProfileViewBasicFeaturesFlowTest extends BaseClassMobile {

    @Test(priority = 6)
    public void profileViewBasicFeaturesFlow() throws Exception {

        //Login
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500000055",
//                        "Admin@194");
//        ExtentTestListener.logStep("Login completed successfully");

        // Profile Icon
        BHomePage homePage = new BHomePage(driver);
        homePage.clickProfileIcon();
        ExtentTestListener.logStep("Profile Icon clicked successfully");

        // Profile Photo Upload
        CProfilePhotoUploadPage profilePhotoPage = new CProfilePhotoUploadPage(driver);
        profilePhotoPage.clickViewProfile();
        profilePhotoPage.uploadProfilePhoto();
        ExtentTestListener.logStep("Profile Photo Uploaded Successfully");


        // Update User Details
        DProfileUserDetailsPage detailsPage = new DProfileUserDetailsPage(driver);
        detailsPage.updateUserDetails();
        ExtentTestListener.logStep("Profile User Details Updated Successfully");
        Thread.sleep(4000);

        // QR Code
        EViewQRCodePage qrCodePage = new EViewQRCodePage(driver);
        qrCodePage.verifyQRCodeFeature();
        ExtentTestListener.logStep("QR Code Feature Completed Successfully");

        //Change Password
        FChangePasswordPage passwordPage = new FChangePasswordPage(driver);
        passwordPage.changePassword();
        ExtentTestListener.logStep("Password Changed Successfully");

        // Contact Us
        GContactUsPage contactUsPage = new GContactUsPage(driver);
        contactUsPage.submitContactUsForm();
        ExtentTestListener.logStep("Contact Us Submitted Successfully");

        driver.navigate().back();

        // Location
        HLocationPage locationPage = new HLocationPage(driver);
        locationPage.selectLocation();
        ExtentTestListener.logStep("Location Selected Successfully");
        Thread.sleep(5000);
        // Address
        IYourAddressPage addressPage = new IYourAddressPage(driver);
        addressPage.validateYourAddressPage();
        ExtentTestListener.logStep("Address Feature Completed Successfully");

        // Free Up Space
        KFreeUpSpacePage freeUpSpacePage = new KFreeUpSpacePage(driver);
        freeUpSpacePage.scrollAndOptimize();
        ExtentTestListener.logStep("Free Up Space Completed Successfully");

        // What's New
        LWhatsNewPage whatsNewPage = new LWhatsNewPage(driver);
        whatsNewPage.verifyWhatsNewFeature();
        ExtentTestListener.logStep("What's New Feature Completed Successfully");

        // Theme & Language
        MThemeAndLanguagePage settingsPage = new MThemeAndLanguagePage(driver);
        settingsPage.verifySettingsFeatures();
        ExtentTestListener.logStep("Theme and Language Feature Completed Successfully");
    }
}