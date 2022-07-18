package test.Lab19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    @Test
    public void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        //Add credential cases in hashmap
        Map<String, String> credData = new HashMap<>();
        credData.put("xtxta@", "P@ssword123");
        credData.put("xtxt@gmail.net", "P@sswor");
        credData.put("xtxt@gmail.com", "P@ssword123");

        try {
            //Test multiple cases with different credential stored in hashmap
            for (String emailStr : credData.keySet()) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, emailStr, credData.get(emailStr));
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
