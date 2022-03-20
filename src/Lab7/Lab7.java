package Lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        boolean exit = false;
        List<Book> bookList = new ArrayList<>();

        while (!exit) {
            //Print menu
            System.out.printf("\n===========MENU===========\n" +
                    "1. Input book information\n" +
                    "2. Find book by ISBN\n" +
                    "0. Exit\n" +
                    "==========================\n\n" +
                    "Your option is: ");

            //Use \n as delimiter for scanner so that it will take the whole line with "space"
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Book book = new Book();
                    //Input title
                    System.out.printf("Please input book's title: ");
                    book.setTitle(scanner.next());

                    //Input ISBN
                    System.out.printf("Please input book's ISBN: ");
                    book.setIsbn(scanner.next());

                    //Input author's name
                    System.out.printf("Please input book's author's name: ");
                    book.setAuthorName(scanner.next());

                    //Input publish year
                    System.out.printf("Please input book's publishing year: ");
                    book.setYear(scanner.nextInt());

                    bookList.add(book);
                    break;

                case 2:
                    System.out.println("");
                    //Input ISBN to find book
                    System.out.printf("Please input book's ISBN to find: ");
                    String findIsbn = scanner.next();
                    boolean foundBook = false; //Mark if book is found or not

                    for (Book book1 : bookList) {
                        if (findIsbn.equals(book1.getIsbn())) {
                            System.out.println("Book found:");
                            System.out.println(book1);
                            foundBook = true;
                        }
                    }

                    if (!foundBook) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 0:
                    exit = true;
                    break;
            }
        }
    }
}
