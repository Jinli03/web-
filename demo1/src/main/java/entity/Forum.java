package entity;

public class Forum {
    private int id;
    private String title;
    private String message;
    private String pperson;
    private String posttime;
    private int likes;
    private String rperson;
    private String rmessage;
    private String rposttime;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPperson() {
        return pperson;
    }

    public void setPperson(String pperson) {
        this.pperson = pperson;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLike(int likes) {
        this.likes = likes;
    }

    public String getRperson() {
        return rperson;
    }

    public void setRperson(String rperson) {
        this.rperson = rperson;
    }

    public String getRmessage() {
        return rmessage;
    }

    public void setRmessage(String rmessage) {
        this.rmessage = rmessage;
    }

    public String getRposttime() {
        return rposttime;
    }

    public void setRposttime(String rposttime) {
        this.rposttime = rposttime;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", pperson='" + pperson + '\'' +
                ", posttime='" + posttime + '\'' +
                ", likes=" + likes +
                ", rperson='" + rperson + '\'' +
                ", rmessage='" + rmessage + '\'' +
                ", rposttime='" + rposttime + '\'' +
                '}';
    }
}
