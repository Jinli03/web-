package less;

import entity.Dish;
import less.CanteenMenu;

import java.util.HashMap;
import java.util.Map;

class SalesRecord {
    private Map<Dish, Integer> sales;

    public SalesRecord() {
        sales = new HashMap<>();
    }

}
