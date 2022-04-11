package Lab12;

import java.util.Comparator;

public class BookYearSortDescend implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book2.getYear(), book1.getYear());
    }
}
