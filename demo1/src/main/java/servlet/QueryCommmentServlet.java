package servlet;

import entity.Comment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryCommentServlet", urlPatterns = {"/QueryCommentServlet"})
public class QueryCommmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        List<Comment> comment = dataService.selectAllComment();
        req.setAttribute("comment",comment);
        System.out.println(comment);
        req.getRequestDispatcher("/displaycomment.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
