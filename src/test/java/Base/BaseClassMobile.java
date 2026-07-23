package Base;

import com.aventstack.extentreports.ExtentReports;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class BaseClassMobile {

    protected static AndroidDriver driver;
    protected static WebDriverWait wait;
    protected static ExtentReports extent;

    // Global Wait Time (Change here if needed)
    public static final int WAIT_TIME = 10;

    //=========================================================
    // Launch Application
    //=========================================================
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {

        ExtentTestListener.logStep("========== MOBILE EXECUTION STARTED ==========");

        if (driver != null) {
            return;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //=====================================================
        // Platform
        //=====================================================
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "HA69Z5PJ8PROEYHA");

        //=====================================================
        // Application
        //=====================================================
        capabilities.setCapability("appPackage", "com.abqaiq.smartsort");
        capabilities.setCapability("appActivity", "com.abqaiq.smartsort.MainActivity");

        //=====================================================
        // Appium Settings
        //=====================================================
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);

        capabilities.setCapability("newCommandTimeout", 300);
        capabilities.setCapability("adbExecTimeout", 120000);
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 120000);
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", 120000);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                capabilities);

        // Global Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));

        extent = ExtentManager.getExtent();

        ExtentTestListener.logStep("Mobile Application Launched Successfully");
    }

    //=========================================================
    // Get Driver
    //=========================================================
    public AndroidDriver getDriver() {
        return driver;
    }

    //=========================================================
    // Get Wait
    //=========================================================
    public WebDriverWait getWait() {
        return wait;
    }

    //=========================================================
    // Screenshot
    //=========================================================
    public static String takeScreenshot(String testName) {

        String folder =
                System.getProperty("user.dir") + File.separator + "screenshots";

        File directory = new File(folder);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName =
                testName + "_" + System.currentTimeMillis() + ".png";

        String destinationPath =
                folder + File.separator + fileName;

        try {

            File source =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destination = new File(destinationPath);

            FileUtils.copyFile(source, destination);

            ExtentTestListener.logStep("Screenshot Captured");

        } catch (Exception e) {

            ExtentTestListener.logStep(
                    "Unable to Capture Screenshot : " + e.getMessage());
        }

        return destinationPath;
    }

    //=========================================================
    // Close Application
    //=========================================================
    @AfterSuite(alwaysRun = true)
    public void tearDown() {

        try {

            if (extent != null) {
                extent.flush();
            }

            if (driver != null) {

                driver.quit();

                driver = null;

                wait = null;

                ExtentTestListener.logStep("Application Closed Successfully");
            }

        } catch (Exception e) {

            ExtentTestListener.logStep(
                    "Error While Closing Driver : " + e.getMessage());
        }
    }
}