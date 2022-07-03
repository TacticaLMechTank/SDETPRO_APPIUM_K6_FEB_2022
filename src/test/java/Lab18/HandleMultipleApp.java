package Lab18;

import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class HandleMultipleApp {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);

            //Login and input correct credential, click on Login button
            // Find and click on nav login button
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.AccessibilityId("button-login-container")));

            // Get Mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate Touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            // Convert coordinates -> PointOption
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            // Scroll down to display all elements
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // Get elements
            MobileElement usernameElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            // Fill the form
            usernameElem.sendKeys("xtxt@hihi.com");
            passwordElem.sendKeys("P@ssword123");
            loginBtnElem.click();

            //Put app to background

            //Switch to setting, turn wi-fi off

            //Come back to app, interact with other element

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
