package entity;

public class Cuser {
    private String username;
    private String canteen;

    public String getUsername() {
        return username;
    }


    public String getCanteen() {
        return canteen;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    @Override
    public String toString() {
        return "Cuser{" +
                "username='" + username + '\'' +
                ", canteen='" + canteen + '\'' +
                '}';
    }
}
