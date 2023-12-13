package entity;

public class Comment {
    private int id;
    private String canteen;
    private String dish;
    private String time;
    private String cperson;
    private String cmessage;
    private float grade;
    private String rperson;
    private String rmessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCperson() {
        return cperson;
    }

    public void setCperson(String cperson) {
        this.cperson = cperson;
    }

    public String getCmessage() {
        return cmessage;
    }

    public void setCmessage(String cmessage) {
        this.cmessage = cmessage;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", canteen='" + canteen + '\'' +
                ", dish='" + dish + '\'' +
                ", time='" + time + '\'' +
                ", cperson='" + cperson + '\'' +
                ", cmessage='" + cmessage + '\'' +
                ", grade=" + grade +
                ", rperson='" + rperson + '\'' +
                ", rmessage='" + rmessage + '\'' +
                '}';
    }
}
