package good;

class ProductSale {
    private String productName;
    private int quantitySold;
    private double pricePerUnit;

    public ProductSale(String productName, int quantitySold, double pricePerUnit) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.pricePerUnit = pricePerUnit;
    }

    public double calculateTotalSale() {
        return quantitySold * pricePerUnit;
    }

    public double calculateSaleWithDiscount(double discountRate) {
        return calculateTotalSale() * (1 - discountRate);
    }

    public String getProductName() {
        return productName;
    }

    // 示例用法
    public static void main(String[] args) {
        ProductSale sale = new ProductSale("Laptop", 2, 800.0);
        double totalSale = sale.calculateTotalSale();
        double discountedSale = sale.calculateSaleWithDiscount(0.1); // 10% discount
        System.out.println("Total Sale for " + sale.getProductName() + ": " + totalSale);
        System.out.println("Sale after discount: " + discountedSale);
    }
}
