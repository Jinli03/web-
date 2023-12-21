package entity;

public class Tsuser {
    private String username;
    private String password;
    private int times;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Tsuser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", times=" + times +
                '}';
    }
}
