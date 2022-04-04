package Lab11;

public abstract class LoginPage {
    ILogin login;
    public void runLogin() {
        login.login();
    }
}
