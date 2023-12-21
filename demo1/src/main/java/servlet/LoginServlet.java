package servlet;

import dao.UserDao;
import entity.Post;
import entity.Tsuser;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;
import select.PostService;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String username = req.getParameter("username");
        servletContext.setAttribute("username", username);
        String password = req.getParameter("password");
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        UserDao dao = new UserDao();
        User user = dao.salogin(loginuser);
        if (user != null) {
            req.setAttribute("username",username);
            req.getRequestDispatcher("/sysadmin.jsp").forward(req,resp);
        }
        user = dao.cmlogin(loginuser);
        if(user != null){
            req.setAttribute("username",username);
            req.getRequestDispatcher("/Cafeteria.jsp").forward(req,resp);
        }
        user = dao.tslogin(loginuser);
        if(user != null){
            DataService dataService = new DataService();
            int times = dataService.selectTsTimes(username);
            times = times + 1;
            dataService.updateTsTimes(username,times);
            List<Tsuser> tsuser = new ArrayList<Tsuser>();
            tsuser = dataService.selectAllTsuserAndTimes();
            System.out.println(tsuser);
            req.setAttribute("tsuser",tsuser);
            req.setAttribute("username",username);

            PostService postService=new PostService();
            List<Post> hotTopics = postService.getHotTopics();
            req.setAttribute("hotTopics", hotTopics);

            req.getRequestDispatcher("/tea_stu_admin.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
