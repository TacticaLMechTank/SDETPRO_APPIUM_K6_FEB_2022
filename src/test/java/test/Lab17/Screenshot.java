package test.Lab17;

import com.sun.org.apache.xml.internal.serializer.OutputPropertyUtils;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Screenshot {

    public static void main(String[] args) {

        //Add dependency commons-io

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {

            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Login")));

            //Full screen
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);//set screenshot file
            String screenFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("full-screen.png");//file location
            FileUtils.copyFile(base64ScreenshotData, new File(screenFileLocation));

            //Selected area
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Login-screen")));

            // Scroll down to display all elements
            TouchAction scrollDown = new TouchAction(appiumDriver);
            scrollDown.press(PointOption.point(10, 300))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(10, 100))
                    .release()
                    .perform();

            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64SLoginFormData = loginFormElem.getScreenshotAs(OutputType.FILE);//set screenshot file
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("login-form.png");//file location
            FileUtils.copyFile(base64SLoginFormData, new File(loginFormFileLocation));

            //Selected element | accessibility id | button-LOGIN
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64SLoginBtnData = loginBtnElem.getScreenshotAs(OutputType.FILE);//set screenshot file
            String loginBtnFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("login-button.png");//file location
            FileUtils.copyFile(base64SLoginBtnData, new File(loginBtnFileLocation));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
