package entity;

public class Cuser {
    private String username;
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cuser{" +
                "username='" + username + '\'' +
                ", canteen='" + canteen + '\'' +
                '}';
    }
}
