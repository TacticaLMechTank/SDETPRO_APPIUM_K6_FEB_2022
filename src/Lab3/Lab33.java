package Lab3;

import java.util.Scanner;

public class Lab33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the length of your integer array: ");
        int arrayLength = scanner.nextInt();
        int[] intArray = new int[arrayLength];
        int[] intArraySorted = new int[arrayLength];

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

        //Output the unsorted array
        System.out.println("");
        System.out.println("Your unsorted array is: ");
        System.out.printf("{");
        for (int i = 0; i < arrayLength - 1; i++) {
            System.out.printf("%d, ", intArray[i]);
        }
        System.out.printf("%d}%n", intArray[arrayLength-1]);

        //Sort the array
        for (int i = 0; i < intArraySorted.length; i++) {
            int max = intArray[0], min = intArray[0], minLocation = 0;
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[j] > max) {
                    max = intArray[j];
                } else if (intArray[j] < min) {
                    min = intArray[j];
                    minLocation = j; //Mark the min number location to later set it to max
                }
                else {
                    //Do nothing
                }
            }

            //Put the min value into the sorted array
            intArraySorted[i] = min;
            intArray[minLocation] = max; //Set the min number to max so that it will not be in the comparison next loop
        }

        //Output the sorted array
        System.out.println("");
        System.out.println("Your sorted array is: ");
        System.out.printf("{");
        for (int i = 0; i < arrayLength - 1; i++) {
            System.out.printf("%d, ", intArraySorted[i]);
        }
        System.out.printf("%d}%n", intArraySorted[arrayLength-1]);
    }
}
