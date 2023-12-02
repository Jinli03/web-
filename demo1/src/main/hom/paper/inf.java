package main.hom.paper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "inf", urlPatterns = {"/inf"})
public class inf extends HttpServlet {
    ArrayList<User> userlist= new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String ageParameter = req.getParameter("age");
        int age = Integer.parseInt(ageParameter);
        String address = req.getParameter("address");
        String hobby = req.getParameter("hobby");
        User user = new User(name,gender,age,address,hobby);
        userlist.add(user);
        System.out.println(user.name);
        req.setAttribute("userlist", userlist);
        req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
    }
    public class User {
        private String name;
        private String gender;
        private int age;
        private String address;
        private String hobby;
        public User(String name, String gender, int age, String address, String hobby) {
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.address = address;
            this.hobby = hobby;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String getHobby() {
            return hobby;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }
    }
}
