import java.util.ArrayList;
import java.util.List;

class SaleItem {
    private String productName;
    private int quantity;
    private double unitPrice;

    public SaleItem(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return productName + " x " + quantity + " @ " + unitPrice + " = " + getTotalPrice();
    }
}

class Invoice {
    private List<SaleItem> items;
    private double totalAmount;

    public Invoice() {
        items = new ArrayList<>();
        totalAmount = 0.0;
    }

    public void addItem(SaleItem item) {
        items.add(item);
        totalAmount += item.getTotalPrice();
    }

    public void printInvoice() {
        System.out.println("Invoice Details:");
        for (SaleItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total Amount: " + totalAmount);
    }

    // 示例用法
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addItem(new SaleItem("Apple", 10, 0.99));
        invoice.addItem(new SaleItem("Banana", 5, 1.49));
        invoice.printInvoice();
    }
}
