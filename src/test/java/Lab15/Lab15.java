package Lab15;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab15 {

    public static void main(String[] args) {

        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav login button
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Scroll down to display all elements
            TouchAction scrollDown = new TouchAction(driver);
            scrollDown.press(PointOption.point(10, 300))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(10, 100))
                .release()
                .perform();
            
            // Get elements
            MobileElement usernameElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            // Fill the form
            usernameElem.sendKeys("xtxt@hihi.com");
            passwordElem.sendKeys("P@ssword123");
            loginBtnElem.click();

            // Get text from login dialog
            WebDriverWait wait = new WebDriverWait(driver, 5L);
            WebElement loginDialogTitleElem = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            System.out.println("Title: " + loginDialogTitleElem.getText());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Quit appium session
            driver.quit();
        }
    }
}
