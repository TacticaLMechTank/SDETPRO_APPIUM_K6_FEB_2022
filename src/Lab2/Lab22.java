package Lab2;

import java.util.Scanner;

public class Lab22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input
        System.out.println("Please input an integer: ");
        int inputNum = scanner.nextInt();

        //Output result
        if (inputNum % 2 == 0) {
            System.out.println("Input is an even number");
        } else {
            System.out.println("Input is an odd number");
        }
    }
}
