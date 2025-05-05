package workshop.bookshop.cart;

import workshop.bookshop.entity.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class ShoppingCart {
    private ArrayList<Publication> items = new ArrayList<>();

    public void addItem(Publication item) {
        items.add(item);
        System.out.println("추가됨: " + item.getTitle());
    }

    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println("제거됨: " + title);
                return true;
            }
        }
        System.out.println("제거 실패: " + title + " 찾을 수 없음");
        return false;
    }

    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###원");
        int i = 1;
        System.out.println("==== 장바구니 내용 ====");
        for (Publication item : items) {
            System.out.println(i++ + ". " + item);
        }
        System.out.println("총 가격: " + df.format(calculateTotalPrice()));
        System.out.println("할인 적용 가격: " + df.format(calculateDiscountedPrice()));
    }

    public int calculateTotalPrice() {
        int sum = 0;
        for (Publication p : items) sum += p.getPrice();
        return sum;
    }

    public int calculateDiscountedPrice() {
        int sum = 0;
        for (Publication p : items) {
            if (p instanceof Magazine) sum += p.getPrice() * 0.9;
            else if (p instanceof Novel) sum += p.getPrice() * 0.85;
            else if (p instanceof ReferenceBook) sum += p.getPrice() * 0.8;
            else sum += p.getPrice();
        }
        return sum;
    }

    public void printStatistics() {
        int novels = 0, mags = 0, refs = 0, etc = 0;
        for (Publication p : items) {
            if (p instanceof Novel) novels++;
            else if (p instanceof Magazine) mags++;
            else if (p instanceof ReferenceBook) refs++;
            else etc++;
        }
        System.out.println("소설: " + novels + ", 잡지: " + mags + ", 참고서: " + refs + ", 기타: " + etc);
    }
}