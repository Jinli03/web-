package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;

@WebServlet(name = "DeleteForumByIdServlet", urlPatterns = {"/DeleteForumByIdServlet"})
public class DeletsForumById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        int id = Integer.parseInt(req.getParameter("id"));
        dataService.deleteForum(id);
        req.getRequestDispatcher("/QueryForumServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
