package Lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        boolean exit = false;
        while (!exit) {
            //Print menu
            System.out.printf("============MENU============\n" +
                    "1. Add number into ArrayList\n" +
                    "2. Print numbers\n" +
                    "3. Get maximum number\n" +
                    "4. Get minimum number\n" +
                    "============================\n" +
                    "Your option is: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.printf("Please input number to add into ArrayList: ");
                    Integer nextNumber = scanner.nextInt();
                    numberList.add (nextNumber);
                    break;
                    
                case 2:
                    System.out.println("");
                    System.out.println("Numbers in ArrayList are:");
                    System.out.println(numberList);
                    System.out.println("");
                    break;

                case 3:
                    Integer maxNumber = Collections.max(numberList);
                    System.out.println("");
                    System.out.println("Maximum number from ArrayList is: " + maxNumber);
                    System.out.println("");
                    break;

                case 4:
                    Integer minNumber = Collections.min(numberList);
                    System.out.println("");
                    System.out.println("Minimum number from ArrayList is: " + minNumber);
                    System.out.println("");
                    break;

                case 0:
                    exit = true;
                    break;
            }
        }
    }
}
