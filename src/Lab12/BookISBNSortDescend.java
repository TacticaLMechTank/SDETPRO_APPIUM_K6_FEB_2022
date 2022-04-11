package Lab12;

import java.util.Comparator;

public class BookISBNSortDescend implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book2.getIsbn().compareTo(book1.getIsbn());
    }
}
