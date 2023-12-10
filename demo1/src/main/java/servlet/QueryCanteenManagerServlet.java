package servlet;

import entity.Cuser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryCanteenManagerServlet", urlPatterns = {"/QueryCanteenManagerServlet"})
public class QueryCanteenManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        List<Cuser> cuser = dataService.selectAllCanteenManager();
        req.setAttribute("cuser",cuser);
        System.out.println(cuser);
        req.getRequestDispatcher("/displaycanteenmanager.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
