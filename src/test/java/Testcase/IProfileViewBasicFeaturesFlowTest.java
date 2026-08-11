package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.IProfileViewBasicFeaturesFlow.*;
import org.testng.annotations.Test;

public class IProfileViewBasicFeaturesFlowTest extends BaseClassMobile {

        @Test(priority = 17)
        public void profileViewBasicFeaturesFlow() throws Exception {
                // Profile Icon
                BHomePage homePage = new BHomePage(driver);
                homePage.clickProfileIcon();
                ExtentTestListener.logStep("Profile Icon clicked successfully");

                // Profile Photo Upload
                CProfilePhotoUploadPage profilePhotoPage = new CProfilePhotoUploadPage(driver);
                profilePhotoPage.clickViewProfile();
                profilePhotoPage.uploadProfilePhoto();
                Thread.sleep(6000);
                ExtentTestListener.logStep("Profile Photo Uploaded Successfully");

                // Update User Details
                DProfileUserDetailsPage detailsPage = new DProfileUserDetailsPage(driver);
                detailsPage.updateUserDetails();
                ExtentTestListener.logStep("Profile User Details Updated Successfully");
                Thread.sleep(13000);

                //Social Media URL
                ESocialMediaURL socialMediaPage = new ESocialMediaURL();
                socialMediaPage.openProfile();

                // QR Code
                FViewQRCodePage qrCodePage = new FViewQRCodePage(driver);
                qrCodePage.verifyQRCodeFeature();
                Thread.sleep(6000);
                ExtentTestListener.logStep("QR Code Feature Completed Successfully");





                //Change Password
                G1ChangePasswordPage passwordPage = new G1ChangePasswordPage(driver);
                passwordPage.changePassword();
                ExtentTestListener.logStep("Password Changed Successfully");


//                //Contact Us
//                Thread.sleep(3000);
//                G2ContactUsPage contactUsPage = new G2ContactUsPage(driver);
//                contactUsPage.submitContactUsForm();
//                ExtentTestListener.logStep("Contact Us Submitted Successfully");


                // Location
                Thread.sleep(5000);
                HLocationPage locationPage = new HLocationPage(driver);
                locationPage.selectLocation();
                ExtentTestListener.logStep("Location Selected Successfully");
                Thread.sleep(3000);

                // Address
                IYourAddressPage addressPage = new IYourAddressPage(driver);
                addressPage.validateYourAddressPage();
                ExtentTestListener.logStep("Address Feature Completed Successfully");

                //Check Update
                JCheckForUpdatePage checkForUpdatePage = new JCheckForUpdatePage(driver);
                checkForUpdatePage.clickCheckForUpdate();

                //Free Up Space
                KFreeUpSpacePage freeUpSpacePage = new KFreeUpSpacePage(driver);
                freeUpSpacePage.scrollAndOptimize();
                ExtentTestListener.logStep("Free Up Space Completed Successfully");


                //What's New
                MWhatsNewPage whatsNewPage = new MWhatsNewPage(driver);
                whatsNewPage.verifyWhatsNewFeature();
                ExtentTestListener.logStep("What's New Feature Completed Successfully");
                Thread.sleep(3000);
                // Privacy Policy
                NPrivacyPolicyPage privacyPolicyPage = new NPrivacyPolicyPage(driver);
                privacyPolicyPage.clickPrivacyPolicy();
                ExtentTestListener.logStep("Privacy Policy Test Completed Successfully");
                Thread.sleep(3000);
                //About Us
                OAboutUsPage aboutUsPage = new OAboutUsPage(driver);
                aboutUsPage.clickAboutUs();

                ExtentTestListener.logStep("About Us Test Completed Successfully");
                Thread.sleep(3000);
                //Theme & Language
                PThemeAndLanguagePage settingsPage = new PThemeAndLanguagePage(driver);
                settingsPage.verifySettingsFeatures();
                ExtentTestListener.logStep("Theme and Language Feature Completed Successfully");
        }
}