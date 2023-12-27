package good;

import java.util.ArrayList;
import java.util.List;

class Meal {
    private String name;
    private List<String> ingredients;

    public Meal(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public void displayMealInfo() {
        System.out.println("Meal: " + name);
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println(" - " + ingredient);
        }
    }
}

class SpectralMealPlanner {
    private List<Meal> meals;

    public SpectralMealPlanner() {
        meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public Meal findMealByName(String name) {
        for (Meal meal : meals) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }

    public void displayAllMeals() {
        for (Meal meal : meals) {
            meal.displayMealInfo();
            System.out.println("--------------------");
        }
    }

    // 示例用法
    public static void main(String[] args) {
        SpectralMealPlanner planner = new SpectralMealPlanner();
        Meal spaghetti = new Meal("Spaghetti");
        spaghetti.addIngredient("Pasta");
        spaghetti.addIngredient("Tomato Sauce");
        planner.addMeal(spaghetti);

        Meal salad = new Meal("Salad");
        salad.addIngredient("Lettuce");
        salad.addIngredient("Tomato");
        planner.addMeal(salad);

        planner.displayAllMeals();
    }
}
