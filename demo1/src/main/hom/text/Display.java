package main.hom.text;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Display", urlPatterns = {"/Display"})
public class Display extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
       if(jdbc1.findData(name)){
           System.out.println("存在用户名");
           if(jdbc1.verify(name,password)){
               System.out.println("密码正确");
               System.out.println("登录成功");
               req.setAttribute("name", name);
               req.getRequestDispatcher("/look.jsp").forward(req, resp);
           }else{
               System.out.println("密码错误，重新登录");
               req.getRequestDispatcher("/index.jsp").forward(req, resp);
           }
       } else{
           System.out.println("不存在用户名");
           jdbc1.insertData(name,password);
           System.out.println("注册成功");
           req.setAttribute("name", name);
           req.getRequestDispatcher("/look.jsp").forward(req, resp);
       }
    }
}
