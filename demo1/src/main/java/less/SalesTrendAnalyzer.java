import java.util.HashMap;
import java.util.Map;

class SalesTrendAnalyzer {
    private Map<String, Integer> monthlySales;

    public SalesTrendAnalyzer() {
        monthlySales = new HashMap<>();
    }

    public void recordSale(String month, int salesAmount) {
        monthlySales.put(month, monthlySales.getOrDefault(month, 0) + salesAmount);
    }

    public void printSalesTrend() {
        System.out.println("Sales Trend:");
        for (Map.Entry<String, Integer> entry : monthlySales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 示例用法
    public static void main(String[] args) {
        SalesTrendAnalyzer analyzer = new SalesTrendAnalyzer();
        analyzer.recordSale("January", 1000);
        analyzer.recordSale("February", 1500);
        analyzer.recordSale("March", 1200);

        analyzer.printSalesTrend();
    }
}
