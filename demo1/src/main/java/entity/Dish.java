package entity;

public class Dish {
    private String id;
    private String kind;
    private String picture;
    private float price;
    private float grade;
    private String canteen;

    public Dish() {
    }
    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 设置
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 获取
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 获取
     * @return grade
     */
    public float getGrade() {
        return grade;
    }

    /**
     * 设置
     * @param grade
     */
    public void setGrade(float grade) {
        this.grade = grade;
    }

    /**
     * 获取
     * @return canteen
     */
    public String getCanteen() {
        return canteen;
    }

    /**
     * 设置
     * @param canteen
     */
    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", grade=" + grade +
                ", canteen='" + canteen + '\'' +
                '}';
    }
}
