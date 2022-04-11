package Lab12;

import java.util.Comparator;

public class BookYearSortAscend implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getYear(), book2.getYear());
    }
}
