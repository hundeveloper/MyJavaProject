package workshop.bookshop.statistics;

import workshop.bookshop.entity.*;
import java.text.DecimalFormat;
import java.util.*;

public class StatisticsAnalyzer {
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        Map<String, Double> avg = calculateAveragePriceByType(publications);
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        double ratio = calculatePublicationRatioByYear(publications, "2007");

        System.out.println("===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        avg.forEach((k, v) -> System.out.println("   - " + k + ": " + df.format(v) + "원"));

        System.out.println("\n2. 출판물 유형 분포:");
        dist.forEach((k, v) -> System.out.println("   - " + k + ": " + df.format(v) + "%"));

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + df.format(ratio) + "%");
        System.out.println("=============================");
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (Publication p : publications) {
            String type = getPublicationType(p);
            total.put(type, total.getOrDefault(type, 0) + p.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avg = new LinkedHashMap<>();
        for (String type : total.keySet()) {
            avg.put(type, total.get(type) / (double) count.get(type));
        }
        return avg;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> count = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        int total = publications.length;
        Map<String, Double> result = new LinkedHashMap<>();
        for (String type : count.keySet()) {
            result.put(type, count.get(type) * 100.0 / total);
        }
        return result;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int total = publications.length;
        int count = 0;
        for (Publication p : publications) {
            if (p.getPublishDate().startsWith(year)) count++;
        }
        return count * 100.0 / total;
    }

    private String getPublicationType(Publication p) {
        if (p instanceof Novel) return "소설";
        else if (p instanceof Magazine) return "잡지";
        else if (p instanceof ReferenceBook) return "참고서";
        return "기타";
    }
}
