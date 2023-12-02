package test;

import dao.UserDao;
import entity.User;

public class Test01 {
    public static void main(String[] args) {
        testlogin();
    }
    public static void testlogin(){
        User loginuser = new User();
        loginuser.setUsername("Jinli03");
        loginuser.setPassword("123457");
        UserDao dao = new UserDao();
        User user = dao.salogin(loginuser);
        System.out.println(user);
    }

}
