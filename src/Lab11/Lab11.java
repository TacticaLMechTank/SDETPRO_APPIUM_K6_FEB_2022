package Lab11;

import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            //Print menu
            System.out.printf("\n=======MENU=======\n" +
                    "1. Internal Login\n" +
                    "2. External Login\n" +
                    "0. Exit\n" +
                    "==================\n\n" +
                    "Your option is: ");

            //Use \n as delimiter for scanner so that it will take the whole line with "space"
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    //Perform internal login
                    LoginPage internalLoginPage = new InternalLoginPage();
                    internalLoginPage.runLogin();
                    break;

                case 2:
                    //Perform external login
                    LoginPage externalLoginPage = new ExternalLoginPage();
                    externalLoginPage.runLogin();
                    break;

                case 0:
                    exit = true;
                    break;
            }
        }
    }
}
