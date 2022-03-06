package Lab5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Map<Integer,String> studentsList= new HashMap<>();
        boolean exit = false;

        while (!exit) {
            //Print menu
            System.out.printf("\n============MENU============\n" +
                    "1. Input student information\n" +
                    "2. Find student by ID\n" +
                    "0. Exit\n" +
                    "============================\n\n" +
                    "Your option is: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.printf("Please input student's name: ");
                    String nameStudent = scanner.next();
                    System.out.printf("Please input student's ID: ");
                    Integer idStudent = scanner.nextInt();
                    studentsList.put(idStudent,nameStudent);
                    break;

                case 2:
                    System.out.println("");
                    System.out.printf("Please input student's ID to find: ");
                    Integer findID = scanner.nextInt();
                    if (studentsList.get(findID) == null) {
                        System.out.println("ID not found!");
                    } else{
                        System.out.printf("\nStudent's name for ID %d is: %s\n", findID, studentsList.get(findID));
                    }
                    break;

                case 0:
                    exit = true;
                    break;
            }
        }
    }
}
