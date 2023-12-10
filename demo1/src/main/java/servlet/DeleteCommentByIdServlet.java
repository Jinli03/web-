package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;

@WebServlet(name = "DeleteCommentByIdServlet", urlPatterns = {"/DeleteCommentByIdServlet"})
public class DeleteCommentByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        int id = Integer.parseInt(req.getParameter("id"));
        dataService.deleteComment(id);
        req.getRequestDispatcher("/QueryCommentServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
