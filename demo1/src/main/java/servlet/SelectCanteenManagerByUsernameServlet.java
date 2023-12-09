package servlet;

import entity.Cuser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
@WebServlet(name = "SelectCanteenManagerByUsernameServlet", urlPatterns = {"/SelectCanteenManagerByUsernameServlet"})
public class SelectCanteenManagerByUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        DataService dataService = new DataService();
        Cuser cuser = dataService.selectCanteenManagerByUsername(username);
        req.setAttribute("cuser",cuser);
        req.getRequestDispatcher("/updatecanteenmanager.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
