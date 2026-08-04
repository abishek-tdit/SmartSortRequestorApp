package Base;

import com.aventstack.extentreports.ExtentReports;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class BaseClassMobile {

    protected static AndroidDriver driver;
    public static WebDriverWait wait;
    protected static ExtentReports extent;

    // Global Wait Time
    public static final int WAIT_TIME = 10;

    // Launch Application
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {

        ExtentTestListener.logStep("========== MOBILE EXECUTION STARTED ==========");

        if (driver != null) {
            return;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();


        // Platform
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "HA69Z5PJ8PROEYHA");


        // Application
        capabilities.setCapability("appPackage", "com.abqaiq.smartsort");
        capabilities.setCapability("appActivity", "com.abqaiq.smartsort.MainActivity");


        // Appium Settings
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


    // Get Driver
    public AndroidDriver getDriver() {
        return driver;
    }

    // Get Wait
    public WebDriverWait getWait() {
        return wait;
    }


    // Screenshot
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
    public void scrollDown() {

        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;
        int startY = (int) (size.height * 0.75);
        int endY = (int) (size.height * 0.35);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
                PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }


    // Swipe Up
    public void swipeUp() {

        driver.executeScript("mobile: scrollGesture", Map.of(
                "left", 100,
                "top", 300,
                "width", 500,
                "height", 1000,
                "direction", "down",
                "percent", 0.8
        ));
    }
    public WebElement waitUntilVisible(By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void restartSession() {

        try {

            System.out.println("Restarting Appium Session");

            if (driver != null) {
                driver.quit();
            }

            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability("platformName", "Android");
            cap.setCapability("automationName", "UiAutomator2");
            cap.setCapability("deviceName", "HA69Z5PJ8PROEYHA");
            cap.setCapability("appPackage", "com.smartsort.utilities");
            cap.setCapability("appActivity", "com.smartsort.utilities.MainActivity");
            cap.setCapability("autoLaunch", true);
            cap.setCapability("noReset", true);

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723/"),
                    cap
            );

            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            wait = new WebDriverWait(driver, Duration.ofSeconds(40));

            System.out.println("Session Restarted");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Close Application
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