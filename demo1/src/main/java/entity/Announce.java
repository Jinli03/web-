package entity;

public class Announce {
    private String title;
    private String time;
    private String content;

    public Announce() {
    }

    public Announce(String title, String time, String content) {
        this.title = title;
        this.time = time;
        this.content = content;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "Announce{title = " + title + ", time = " + time + ", content = " + content + "}";
    }
}
