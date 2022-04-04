package Lab11;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class SSOLogin implements ILogin {

    @Override
    public void login() {
        //Use \n as delimiter for scanner so that it will take the whole line with "space"
        String username;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        //Check correct login information
        //Ask username
        System.out.println("Username: ");
        username = scanner.next();

        if (username.equals("admin")) {
            boolean isMatch = false;
            while (!isMatch) {
                //Prepare captcha
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int len = 5;
                Random random = new Random();
                StringBuilder buffer = new StringBuilder(len);
                for (int i = 0; i < len; i++) {
                    int randomLimitedInt = leftLimit + (int)
                            (random.nextFloat() * (rightLimit - leftLimit + 1));
                    buffer.append((char) randomLimitedInt);
                }
                String captcha = buffer.toString();
                String input;

                //Ask for captcha
                System.out.println("To continue, please type the following characters (case sensitive): \u001B[33m" + captcha + "\u001B[0m");
                input = scanner.next();
                if (input.equals(captcha)) {
                    System.out.println("Login successfully!");
                    isMatch = true;
                } else {
                    System.out.println("Incorrect captcha!");
                }
            }

        } else {
            System.out.println("Invalid username");
        }
    }
}
