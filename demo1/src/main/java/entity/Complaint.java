package entity;

public class Complaint {
    private int id;
    private String title;

    private String details;
    private String username; // 发表人
    private String canteen; // 食堂
    private String dish; // 菜品
    private String responder; // 回复人
    private String response; // 回复内容
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


}
