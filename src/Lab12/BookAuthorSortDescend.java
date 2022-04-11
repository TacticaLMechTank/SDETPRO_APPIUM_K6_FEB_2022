package Lab12;

import java.util.Comparator;

public class BookAuthorSortDescend implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book2.getAuthorName().compareTo(book1.getAuthorName());
    }
}
