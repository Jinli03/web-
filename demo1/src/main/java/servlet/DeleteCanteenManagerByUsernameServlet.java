package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
@WebServlet(name = "DeleteCanteenManagerByUsernameServlet", urlPatterns = {"/DeleteCanteenManagerByUsernameServlet"})
public class DeleteCanteenManagerByUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        String username = req.getParameter("username");
        dataService.deleteCanteenManager(username);
        req.getRequestDispatcher("/QueryCanteenManagerServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
