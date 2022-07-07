package test.Lab16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lab16_1 {
    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav login button
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navLoginBtnElem.click();

            // Wait until on form screen
            WebDriverWait wait = new WebDriverWait(driver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.xpath("//android.widget.TextView[contains(@text, \"Form components\")]")));

            // Get Mobile window size
            Dimension windowSize = driver.manage().window().getSize();
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

            // Get elements
            MobileElement textInputElem = driver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement switchElem = driver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement switchTextElem = driver.findElement(MobileBy.AccessibilityId("switch-text"));

            // Fill the form and turn switch
            textInputElem.sendKeys("Have a nice day, happy coding!");
            switchElem.click();
            if (switchTextElem.getText().equals("Click to turn the switch OFF")) {
                System.out.println("Switch Result: Switch is ON");
            } else {
                System.out.println("Switch Result: Switch is OFF");
            }

            // Swipe down
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // Find and click on drop box
            MobileElement dropBoxElem = driver.findElement(MobileBy.AccessibilityId("Dropdown"));
            dropBoxElem.click();

            // Get text from dropbox dialog, select "Appium is awesome"
            wait = new WebDriverWait(driver, 5L);
            WebElement dropBoxDialogElem = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, \"Appium is awesome\")]")));
            dropBoxDialogElem.click();

            // Find Active button and click, check result
            MobileElement activeBtnElem = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtnElem.click();
            WebElement activeBtnDialogElem = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/message")));
            System.out.println("Active Result: " + activeBtnDialogElem.getText());

            // DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}