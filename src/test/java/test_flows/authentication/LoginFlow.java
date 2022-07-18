package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;
    private String emailStr;
    private String passwordStr;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String emailStr, String passwordStr) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.emailStr = emailStr;
        this.passwordStr = passwordStr;

    }

    public void login(){
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComponent();
        if(!emailStr.isEmpty()){
            MobileElement emailElem = loginFormComp.emailElem();
            emailElem.clear();
            emailElem.sendKeys(emailStr);
        }

        if(!passwordStr.isEmpty()){
            MobileElement passwordElem = loginFormComp.passwordElem();
            passwordElem.clear();
            passwordElem.sendKeys(passwordStr);
        }

        loginFormComp.clickOnLoginBtn();
    }

    public void verifyLogin(){
        boolean isEmailValid = EmailValidator.getInstance().isValid(emailStr);
        boolean isPasswordValid = passwordStr.length() >= 8;

        System.out.printf("Email: %s, %b | Password: %s, %b\n", emailStr, isEmailValid, passwordStr, isPasswordValid);

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComponent();

        if(isEmailValid && isPasswordValid){
            verifyCorrectLoginCreds(loginFormComp);
        }

        if(!isEmailValid){
            verifyIncorrectEmailStr(loginFormComp);
        }

        if(!isPasswordValid){
            verifyIncorrectPasswordStr(loginFormComp);
        }

    }

    private void verifyCorrectLoginCreds(LoginFormComponent loginFormComp) {
        String actualValidCreds = loginFormComp.getValidCreds();
        String expectedValidCreds = "You are logged in!";

        System.out.println("actualValidCreds: " + actualValidCreds);
        System.out.println("expectedValidCreds: " + expectedValidCreds);
        System.out.println("===============================================================\n");
    }

    private void verifyIncorrectEmailStr(LoginFormComponent loginFormComp) {
        String actualInvalidEmailStr = loginFormComp.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email address";

        System.out.println("actualInvalidEmailStr: " + actualInvalidEmailStr);
        System.out.println("expectedInvalidEmailStr: " + expectedInvalidEmailStr);
        System.out.println("===============================================================\n");
    }

    private void verifyIncorrectPasswordStr(LoginFormComponent loginFormComp) {
        String actualInvalidPasswordStr = loginFormComp.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";

        System.out.println("actualInvalidPasswordStr: " + actualInvalidPasswordStr);
        System.out.println("expectedInvalidPasswordStr: " + expectedInvalidPasswordStr);
        System.out.println("===============================================================\n");
    }
}
