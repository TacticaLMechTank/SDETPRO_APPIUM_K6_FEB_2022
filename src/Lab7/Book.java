package Lab7;

public class Book {
    private String isbn;
    private String title;
    private String authorName;
    private int year;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ISBN: '" + isbn + '\'' + "\n" +
                "Title: '" + title + '\'' + "\n" +
                "Author's Name: '" + authorName + '\'' + "\n" +
                "Year: " + year;
    }
}
