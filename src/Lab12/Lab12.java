package Lab12;

import java.util.*;

public class Lab12 {
    public static void main(String[] args) {
        boolean exit = false;
        List<Book> bookList = new ArrayList<>();

        while (!exit) {
            //Print menu
            System.out.printf("\n==============MENU==============\n" +
                    "1. Insert book information\n" +
                    "2. Print sorted book by property\n" +
                    "0. Exit\n" +
                    "================================\n\n" +
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

                    //Input author's name
                    System.out.printf("Please input book's author's name: ");
                    book.setAuthorName(scanner.next());

                    //Input ISBN
                    System.out.printf("Please input book's ISBN: ");
                    book.setIsbn(scanner.next());

                    //Input publish year
                    System.out.printf("Please input book's publishing year: ");
                    book.setYear(scanner.nextInt());

                    bookList.add(book);
                    break;

                case 2:
                    System.out.println("");
                    //Input property to sort book
                    System.out.println("Please input book's property to sort (choose 1 option shown below): ");
                    System.out.println("1. Title");
                    System.out.println("2. Author");
                    System.out.println("3. ISBN");
                    System.out.println("4. Year");
                    int sortProperty = scanner.nextInt();

                    //Input sort order
                    System.out.println("Please input order to sort (choose 1 option shown below): ");
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    int sortOrder = scanner.nextInt();

                    //Print sorted book
                    printSortedBook(bookList, sortProperty, sortOrder);

                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }

    private static void printSortedBook(List<Book> bookList, int sortProperty, int sortOrder) {
        if (bookList == null) {
            System.out.println("Book list is empty.");
        } else {
            switch (sortOrder) {
                case 1: //Ascending
                    switch (sortProperty) {
                        case 1:
                            Collections.sort(bookList, new BookTitleSortAscend());
                            printBookList(bookList);
                            break;
                        case 2:
                            Collections.sort(bookList, new BookAuthorSortAscend());
                            printBookList(bookList);
                            break;
                        case 3:
                            Collections.sort(bookList, new BookISBNSortAscend());
                            printBookList(bookList);
                            break;
                        case 4:
                            Collections.sort(bookList, new BookYearSortAscend());
                            printBookList(bookList);
                            break;
                    }
                    break;

                case 2: //Descending
                    switch (sortProperty) {
                        case 1:
                            Collections.sort(bookList, new BookTitleSortDescend());
                            printBookList(bookList);
                            break;
                        case 2:
                            Collections.sort(bookList, new BookAuthorSortDescend());
                            printBookList(bookList);
                            break;
                        case 3:
                            Collections.sort(bookList, new BookISBNSortDescend());
                            printBookList(bookList);
                            break;
                        case 4:
                            Collections.sort(bookList, new BookYearSortDescend());
                            printBookList(bookList);
                            break;
                    }
                    break;
            }
        }
    }

    private static void printBookList(List<Book> bookList) {
        int order = 1;
        for (Book book : bookList) {
            System.out.print(order + ". ");
            System.out.println(book);
            System.out.println("");
            order++;
        }
    }
}
