package Lab8;

import Lab7.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab81 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            //Print menu
            System.out.printf("\n=============MENU=============\n" +
                    "1. Input employee information\n" +
                    "2. Calculate total salary\n" +
                    "0. Exit\n" +
                    "==============================\n\n" +
                    "Your option is: ");

            //Use \n as delimiter for scanner so that it will take the whole line with "space"
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Employee employee = new Employee();
                    //Input name
                    System.out.printf("Please input employee's name: ");
                    employee.setName(scanner.next());

                    //Input type
                    System.out.println("Please input employee's type. Available options:");
                    System.out.println("1. Full time");
                    System.out.println("2. Contractor");
                    System.out.printf("Employee's type is: ");
                    employee.setEmployeeType(scanner.next());

                    //Set salary
                    employee.setSalary();

                    //Add to list
                    employeeList.add(employee);
                    break;

                case 2:
                    int fullTimeNum = 0;
                    int contractorNum = 0;
                    int totalSalary = totalSalary(employeeList); //Calculate total salary by method

                    //Count the number of each employee type
                    for (Employee employee1 : employeeList) {
                        switch (employee1.getEmployeeType()) {
                            case "Full time":
                                fullTimeNum++;
                                break;
                            case "Contractor":
                                contractorNum++;
                                break;
                        }
                    }

                    //Output result
                    System.out.println("Total number of Full time employee is: " + fullTimeNum);
                    System.out.println("Total number of Contractor employee is: " + contractorNum);
                    System.out.println("Total salary is: " + totalSalary);
                    break;

                case 0:
                    exit = true;
                    break;
            }
        }
    }

    public static int totalSalary(List<Employee> employeeList) {
        int totalSalary = 0;
        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }
}
