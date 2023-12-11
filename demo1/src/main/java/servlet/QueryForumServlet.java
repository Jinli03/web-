package servlet;

import entity.Comment;
import entity.Forum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryForumServlet", urlPatterns = {"/QueryForumServlet"})
public class QueryForumServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        List<Forum> forum = dataService.selectAllForum();
        List<String> titles = dataService.selectAllForumTitles();
        req.setAttribute("forum",forum);
        req.setAttribute("titles",titles);
        System.out.println(forum);
        System.out.println(titles);
        req.getRequestDispatcher("/displayforum.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
