package Lab11;

import java.util.Scanner;

public class NormalLogin implements ILogin {

    @Override
    public void login() {
        //Use \n as delimiter for scanner so that it will take the whole line with "space"
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        //Check attempt,
        int attempt = 0;
        final int MAX_ATTEMPT = 5;

        while (attempt < MAX_ATTEMPT) {
            //Ask username and password
            System.out.println("Username: ");
            username = scanner.next();
            System.out.println("Password: ");
            password = scanner.next();

            //Check login info
            if (username.equals("admin") && password.equals("P@ssword123")) {
                System.out.println("Login successfully!");
                attempt = 6;
            } else {
                System.out.println("Wrong username or password. Please try again!");
                attempt++;
            }
        }
        if (attempt == 5) {
            System.out.println("Too many failed attempts!");
        }
    }
}
