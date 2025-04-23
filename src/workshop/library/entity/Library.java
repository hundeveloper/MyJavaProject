package workshop.library.entity;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.borrow();
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            book.printInfo();
            return true;
        }
        System.out.println("대출 실패: 도서가 존재하지 않거나 이미 대출 중입니다.");
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book != null && !book.isAvailable()) {
            book.giveBack();
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            book.printInfo();
            return true;
        }
        System.out.println("반납 실패: 도서가 존재하지 않거나 대출 중이 아닙니다.");
        return false;
    }

    public void printLibraryStatus() {
        int available = 0;
        int borrowed = 0;
        for (Book book : books) {
            if (book.isAvailable()) available++;
            else borrowed++;
        }
        System.out.println("\n도서관 현재 상태:");
        System.out.println("전체 도서 수: " + books.size());
        System.out.println("대출 가능 도서 수: " + available);
        System.out.println("대출 중인 도서 수: " + borrowed);
    }

    public void printAvailableBooks() {
        System.out.println("===== 대출 가능한 도서 목록 =====");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.printShortInfo();
            }
        }
    }
}