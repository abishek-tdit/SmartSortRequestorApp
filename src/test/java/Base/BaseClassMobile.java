package Base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class BaseClassMobile {

    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public static ExtentReports extent;

    @BeforeSuite
    public void setUp() throws Exception {

        System.out.println("===== BEFORE SUITE : Launching Mobile App =====");

        extent = ExtentManager.getExtent();

        if (driver == null) {

            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability("platformName", "Android");
            cap.setCapability("automationName", "UiAutomator2");
            cap.setCapability("deviceName", "Android");

            cap.setCapability("appPackage", "com.abqaiq.smartsort");
            cap.setCapability("appActivity", "com.abqaiq.smartsort.MainActivity");

            cap.setCapability("noReset", true);

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    cap
            );

            wait = new WebDriverWait(driver, Duration.ofSeconds(40));

            System.out.println("Mobile Application Launched Successfully");
        }
    }


    // ✅ ADD METHOD HERE 👇 (INSIDE CLASS)
    public String takeScreenshot(String testName) {

        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved: " + path);

        } catch (Exception e) {
            System.out.println("Screenshot failed");
        }

        return path;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {

        if (extent != null) {
            extent.flush();
        }

        System.out.println("===== AFTER SUITE : Closing Mobile App =====");

        try {
            if (driver != null) {
                // driver.quit();   // ✅ COMMENT THIS LINE
                // driver = null;   // optional (can comment)
            }
        } catch (Exception e) {
            System.out.println("Driver already closed");
        }
    }
}