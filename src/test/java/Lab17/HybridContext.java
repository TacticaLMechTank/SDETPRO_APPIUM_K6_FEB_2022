package Lab17;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            //Open webview screen
            By webviewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webviewNavBtnElem = appiumDriver.findElement(webviewNavBtnSel);
            webviewNavBtnElem.click();

            //Wait for context to load
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            //Get context name
            //Option 1: forEach
//            appiumDriver.getContextHandles().forEach(context -> {   //can be short into forEach(System.out::println)
//                System.out.println(context);
//            });
            //Option 2: enhanced for
//            for (String context : appiumDriver.getContextHandles()) {
//                System.out.println(context);
//            }

            //Switch to web view context
            appiumDriver.context(Contexts.WEB_VIEW);

            //Interact on web view elements
            WebElement navToggleBtnElem = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();
            List<MobileElement> menuItemElems = appiumDriver.findElementsByCssSelector(".menu__list li a");
            List<MenuItemData> menuItemDataList = new ArrayList<>();
            Map<String, String> menuItemDataMap = new HashMap<>();

            if (menuItemElems.isEmpty()){
                throw new RuntimeException("[ERR] The item list is empty!");
            }

            for (MobileElement menuItemElem : menuItemElems) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if (itemText.isEmpty()) {
                    menuItemDataList.add(new MenuItemData("Github", itemHref));
                    menuItemDataMap.put("Github", itemHref);
                }
                else {
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));
                    menuItemDataMap.put(itemText, itemHref);
                }
            }

            menuItemDataList.forEach(menuItemData -> {
                System.out.println(menuItemData.getName() + ": " + menuItemData.getHref());
            });

            System.out.println("================================================");
            menuItemDataMap.keySet().forEach(key -> {
                System.out.println(key + ": " + menuItemDataMap.get(key));
            });

            //Switch back to NATIVE context
            appiumDriver.context(Contexts.NATIVE);

            //Find login button
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

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }

    public static class MenuItemData {
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }
    }
}
