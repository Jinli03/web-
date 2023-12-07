package servlet;

import dao.UserDao;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        UserDao dao = new UserDao();
        User user = dao.salogin(loginuser);
        if(user != null){
            req.setAttribute("username",username);
            req.getRequestDispatcher("/sysadmin.jsp").forward(req,resp);
        }
        user = dao.cmlogin(loginuser);
        if(user != null){
            req.setAttribute("username",username);
            req.getRequestDispatcher("/canteen-manager.jsp").forward(req,resp);
        }
        user = dao.tslogin(loginuser);
        if(user != null){
            req.setAttribute("username",username);
            req.getRequestDispatcher("/ts.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}