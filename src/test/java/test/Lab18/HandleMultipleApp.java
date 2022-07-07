package test.Lab18;

import driver.AppPackages;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            //Switch to setting, turn wi-fi off
            appiumDriver.activateApp(AppPackages.settings);
            By wifiLabelSel = MobileBy.xpath("//*[@text='Wi‑Fi']");
            By wifiStatusSel = MobileBy.id("com.android.settings:id/switch_text");

            //Navigate to wi-fi list
            MobileElement wifiLabelElem = appiumDriver.findElement(wifiLabelSel);
            wifiLabelElem.click();

            //Turn on/off wi-fi
            MobileElement wifiStatusElem = appiumDriver.findElement(wifiStatusSel);
            String wifiStatusStr = wifiStatusElem.getText().trim();
            boolean wifiIsOn = wifiStatusStr.equalsIgnoreCase("on");
            if (wifiIsOn){
                wifiStatusElem.click();
            }

            //Come back to app, interact with other element
            appiumDriver.activateApp(AppPackages.wdio);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

            // DEBUG PURPOSE ONLY
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
