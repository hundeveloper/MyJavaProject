package workshop.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;
    private boolean isAvailable;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public boolean isAvailable() { return isAvailable; }

    public void borrow() {
        isAvailable = false;
    }

    public void giveBack() {
        isAvailable = true;
    }

    public void printInfo() {
        System.out.println("책 제목: " + title +
            "\t저자: " + author +
            "\tISBN: " + isbn +
            "\t출판년도: " + year +
            "\t대출 가능 여부: " + (isAvailable ? "가능" : "대출 중"));
    }

    public void printShortInfo() {
        System.out.println("책 제목: " + title +
            "\t저자: " + author +
            "\tISBN: " + isbn +
            "\t출판년도: " + year +
            "\t대출 가능 여부: " + (isAvailable ? "가능" : "대출 중"));
        System.out.println("------------------------");
    }
}