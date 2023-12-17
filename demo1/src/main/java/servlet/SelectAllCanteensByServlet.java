package servlet;

import entity.Canteen;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllCanteensByServlet", urlPatterns = {"/SelectAllCanteensByServlet"})
public class SelectAllCanteensByServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        List<Canteen> canteen = dataService.selectAllCanteen();
        req.setAttribute("canteen",canteen);
        System.out.println(canteen);
        req.getRequestDispatcher("/displaycanteenlist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
