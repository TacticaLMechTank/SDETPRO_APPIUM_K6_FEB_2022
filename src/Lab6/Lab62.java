package Lab6;

import java.util.Scanner;

public class Lab62 {
    public static void main(String[] args) {
        //Init variable
        String myPassword = "password123";
        boolean isCorrect = false;
        int inputTime = 0;
        final int MAX_INPUT_TIME = 3;

        //Begin to input the time string
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Please input your password:");

        //Allow input until reach MAX_INPUT_TIME
        while (!isCorrect && (inputTime < MAX_INPUT_TIME)) {
            String passwordInput = scanner.nextLine();
            if (passwordInput.equals(myPassword)) {
                System.out.println("Password is CORRECT!");
                isCorrect = true;
            } else if (inputTime < MAX_INPUT_TIME - 1){ //Print try again except on the last try
                System.out.println("Password is INCORRECT! Please try again:");
                inputTime++;
            } else {
                inputTime++;
            }
        }
        System.out.println("Too many failed attempts. Log in with password is disabled!");
    }
}
