package Lab12;

import java.util.Comparator;

public class BookTitleSortDescend implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book2.getTitle().compareTo(book1.getTitle());
    }
}
