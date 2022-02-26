package Lab3;

import java.util.Scanner;

public class Lab31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the length of your integer array: ");
        int arrayLength = scanner.nextInt();
        int[] intArray = new int[arrayLength];

        //Begin to input numbers into array
        for (int i=0; i < arrayLength; i++) {
            if ((i+1) % 10 == 1 && (i+1) % 100 != 11) {
                System.out.printf("Please input %dst number: ", i+1);
            } else if ((i+1) % 10 == 2 && (i+1) % 100 != 12) {
                System.out.printf("Please input %dnd number: ", i+1);
            } else if ((i+1) % 10 == 3 && (i+1) % 100 != 13) {
                System.out.printf("Please input %drd number: ", i+1);
            } else {
                System.out.printf("Please input %dth number: ", i+1);
            }
            intArray[i] = scanner.nextInt();
        }

        //Output the array
        System.out.println("");
        System.out.println("Your array is: ");
        System.out.printf("{");
        for (int i = 0; i < arrayLength - 1; i++) {
            System.out.printf("%d, ", intArray[i]);
        }
        System.out.printf("%d}%n", intArray[arrayLength-1]);

        //Count the odd and even numbers
        int odd = 0, even = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        //Output result
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
    }
}
