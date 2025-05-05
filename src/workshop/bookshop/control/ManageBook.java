package workshop.bookshop.control;

import workshop.bookshop.entity.*;
import workshop.bookshop.statistics.*;

public class ManageBook {
    public static void main(String[] args) {
        Publication[] books = {
                new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
                new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
                new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
                new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
                new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
                new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
                new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i+1) + ". " + books[i]);
        }

        // 가격 변경
        System.out.println("\n==== 가격 변경 ====");
        Publication p = books[6];
        System.out.println(p.getTitle() + " 변경 전 가격: " + p.getPrice() + "원");
        int before = p.getPrice();
        modifyPrice(p);
        int after = p.getPrice();
        System.out.println(p.getTitle() + " 변경 후 가격: " + after + "원");
        System.out.println("차액: " + (before - after) + "원\n");

        // 통계
        StatisticsAnalyzer sa = new StatisticsAnalyzer();
        sa.printStatistics(books);
    }

    public static void modifyPrice(Publication p) {
        if (p instanceof Magazine) p.setPrice((int)(p.getPrice() * 0.6));
        else if (p instanceof Novel) p.setPrice((int)(p.getPrice() * 0.8));
        else if (p instanceof ReferenceBook) p.setPrice((int)(p.getPrice() * 0.9));
    }
}