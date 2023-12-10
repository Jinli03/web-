package entity;

public class Canteen {
    private String name;
    private String time;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Canteen{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
