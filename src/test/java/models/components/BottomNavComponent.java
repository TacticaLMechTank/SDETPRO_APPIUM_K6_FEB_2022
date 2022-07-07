package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottomNavComponent {
    private final static By usernameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By homeIconSel = MobileBy.AccessibilityId("Home");
    private final static By webviewIconSel = MobileBy.AccessibilityId("Webview");
    private final static By loginIconSel = MobileBy.AccessibilityId("Login");
    private final static By formsIconSel = MobileBy.AccessibilityId("Forms");
    private final static By swipeIconSel = MobileBy.AccessibilityId("Swipe");
    private final static By dragIconSel = MobileBy.AccessibilityId("Drag");
    private final AppiumDriver<MobileElement> driver;

    public MobileElement usernameElem() {
        return driver.findElement(usernameSel);
    }

    public MobileElement passwordElem() {
        return driver.findElement(passwordSel);
    }

    public MobileElement loginBtnElem() {
        return driver.findElement(loginBtnSel);
    }

    public BottomNavComponent(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void clickOnHomeIcon() {
        driver.findElement(homeIconSel).click();
    }

    public void clickOnWebviewIcon() {
        driver.findElement(webviewIconSel).click();
    }

    public void clickOnFormsIcon() {
        driver.findElement(formsIconSel).click();
    }

    public void clickOnSwipeIcon() {
        driver.findElement(swipeIconSel).click();
    }

    public void clickOnDragIcon() {
        driver.findElement(dragIconSel).click();
    }

    public void clickOnLoginIcon() {
        driver.findElement(loginIconSel).click();
    }
}
