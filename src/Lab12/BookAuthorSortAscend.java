package Lab12;

import java.util.Comparator;

public class BookAuthorSortAscend implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getAuthorName().compareTo(book2.getAuthorName());
    }
}
