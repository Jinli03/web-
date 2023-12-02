package main.hom.text;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.hom.text.Chat;
import main.hom.text.jdbc1;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "resolve", urlPatterns = {"/resolve"})
public class resolve extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String name = req.getParameter("name");
        String currenttime = req.getParameter("currenttime");
        String inf = req.getParameter("inf");
        System.out.println(title);
        System.out.println(name);
        System.out.println(currenttime);
        System.out.println(inf);
        jdbc1.insertInf(title,name,currenttime,inf);
        req.setAttribute("name", name);
        List<String> distinctTitles = jdbc1.getDistinctTitles();
        req.setAttribute("distinctTitles", distinctTitles);
        List<Chat> chatList = jdbc1.getAllChatDetails();
        req.setAttribute("chatList", chatList);
        req.getRequestDispatcher("/look.jsp").forward(req, resp);

    }

}
