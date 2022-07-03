package Lab16;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab16_2 {
    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Get Mobile window size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate Touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 0;
            int yEndPoint = 50 * screenHeight / 100;

            // Convert coordinates -> PointOption
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .press(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // List notifications
            Map<String, String> notifications = new HashMap<>();
            List<MobileElement> notificationElems = driver.findElements(MobileBy.id("android:id/notification_main_column"));
            for (MobileElement notificationElem : notificationElems) {

                // Get notification title
                MobileElement titleElem = notificationElem.findElement(MobileBy.id("android:id/title"));
                String titleText = titleElem.getText();

                // Get notification content
                MobileElement contentElem;
                try {
                    contentElem = notificationElem.findElement(MobileBy.id("android:id/text")); // In case content is text
                } catch (Exception e) {
                    contentElem = notificationElem.findElement(MobileBy.id("android:id/big_text")); // In case content is big_text
                }
                String contentText = contentElem.getText();

                notifications.put(titleText, contentText);
            }

            // Output notification list
            if (notifications.keySet().isEmpty()){
                throw new RuntimeException("[ERR] there is no notification to show!");
            } else {
                for (String title : notifications.keySet()) {
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + notifications.get(title));
                }
            }

            // Swipe up to dismiss notification bar
            touchAction
                    .longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}