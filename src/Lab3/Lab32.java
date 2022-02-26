package Lab3;

import java.util.Scanner;

public class Lab32 {
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

        //Find the max and min value in array
        int max = intArray[0], min = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            } else if (intArray[i] < min) {
                min = intArray[i];
            }
            else {
                //Do nothing
            }
        }

        //Output result
        System.out.println("Maximum number in array: " + max);
        System.out.println("Minimum number in array: " + min);
    }
}
