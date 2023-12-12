package entity;

public class Dish {
    private String id;
    private String kind;
    private String picture;

    private String price;

    public Dish() {
    }

    public Dish(String id, String kind, String picture) {
        this.id = id;
        this.kind = kind;
        this.picture = picture;
    }

    public Dish(String id, String kind, String picture, String price) {
        this.id = id;
        this.kind = kind;
        this.picture = picture;
        this.price = price;
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

    public String toString() {
        return "Dish{id = " + id + ", kind = " + kind + ", picture = " + picture + "}";
    }

    /**
     * 获取
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
