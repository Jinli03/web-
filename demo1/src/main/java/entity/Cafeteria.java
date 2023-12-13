package entity;

public class Cafeteria {
    private String description;
    private String hours;

    // 无参构造函数
    public Cafeteria() {
    }

    // 带所有参数的构造函数
    public Cafeteria(String description, String hours) {
        this.description = description;
        this.hours = hours;
    }

    // description的getter和setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // hours的getter和setter
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    // toString方法（可选）
    @Override
    public String toString() {
        return "CafeteriaInfo{" +
                "description='" + description + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}
