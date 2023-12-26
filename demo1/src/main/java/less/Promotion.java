package less;

import java.util.HashMap;
import java.util.Map;

class Promotion {
    String name;
    private double discountRate; // 折扣率

    public Promotion(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - discountRate);
    }

    @Override
    public String toString() {
        return name + " - Discount: " + (discountRate * 100) + "%";
    }
}

class PromotionManager {
    private Map<String, Promotion> promotions;

    public PromotionManager() {
        promotions = new HashMap<>();
    }

    public void addPromotion(Promotion promotion) {
        promotions.put(promotion.name, promotion);
    }

    public double calculateDiscountedPrice(String promotionName, double originalPrice) {
        Promotion promotion = promotions.get(promotionName);
        if (promotion != null) {
            return promotion.applyDiscount(originalPrice);
        }
        return originalPrice;
    }

    public void printAllPromotions() {
        for (Promotion promotion : promotions.values()) {
            System.out.println(promotion);
        }
    }

    // 示例用法
    public static void main(String[] args) {
        PromotionManager manager = new PromotionManager();
        manager.addPromotion(new Promotion("Summer Special", 0.15));
        manager.addPromotion(new Promotion("Festive Offer", 0.25));

        double discountedPrice = manager.calculateDiscountedPrice("Summer Special", 200);
        System.out.println("Discounted Price: " + discountedPrice);

        manager.printAllPromotions();
    }
}
