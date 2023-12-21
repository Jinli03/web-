package entity;

public class Complaint {
    private int id;
    private String title;

    private String details;
    private String username; // 发表人
    private String canteen; // 食堂
    private String dish; // 菜品
    private String responder; // 回复人
    private String reply; // 回复内容

    private int replied;

    public Complaint() {
    }

    public Complaint(int id, String title, String details, String username, String canteen, String dish, String responder, String reply, boolean replied) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.username = username;
        this.canteen = canteen;
        this.dish = dish;
        this.responder = responder;
        this.reply = reply;
        this.replied = 0;
    }

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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }


    /**
     * 获取
     * @return replied
     */
    public int getReplied() {
        return replied;
    }

    /**
     * 设置
     * @param replied
     */
    public void setReplied(int replied) {
        this.replied = replied;
    }

    public String toString() {
        return "Complaint{id = " + id + ", title = " + title + ", details = " + details + ", username = " + username + ", canteen = " + canteen + ", dish = " + dish + ", responder = " + responder + ", reply = " + reply + ", replied = " + replied + "}";
    }
}
