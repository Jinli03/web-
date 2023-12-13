package servlet;

import entity.Canteen;
import entity.Comment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectDishCommentByIdServlet", urlPatterns = {"/SelectDishCommentByIdServlet"})
public class SelectDishCommentByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DataService dataService = new DataService();
        List<Comment> comment = dataService.selectDishCommentById(id);
        req.setAttribute("comment",comment);
        System.out.println(comment);
        req.getRequestDispatcher("/displaydishcommentbyid.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
