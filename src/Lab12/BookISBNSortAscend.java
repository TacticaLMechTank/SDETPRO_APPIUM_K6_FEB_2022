package Lab12;

import java.util.Comparator;

public class BookISBNSortAscend implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getIsbn().compareTo(book2.getIsbn());
    }
}
