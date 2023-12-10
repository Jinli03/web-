package servlet;

import entity.Cuser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;

@WebServlet(name = "UpdateCanteenManagerServlet", urlPatterns = {"/UpdateCanteenManagerServlet"})
public class UpdateCanteenManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String canteen = req.getParameter("canteen");
        Cuser cuser = new Cuser();
        cuser.setUsername(username);
        cuser.setPassword(password);
        cuser.setCanteen(canteen);
        dataService.updateCanteenManager(cuser);
        req.getRequestDispatcher("/QueryCanteenManagerServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
