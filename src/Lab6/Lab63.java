package Lab6;

import java.util.Scanner;

public class Lab63 {
    public static void main(String[] args) {
        //Begin to input the string
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Please input a new string to extract digit character:");
        String myString = scanner.nextLine();

        //Print digit character
        char[] myChar = myString.toCharArray();   //Convert to array
        for (char character : myChar) {
            if (Character.isDigit(character)) {
                System.out.print(character);
            }
        }
    }
}
