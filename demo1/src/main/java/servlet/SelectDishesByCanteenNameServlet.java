package servlet;

import entity.Dish;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectDishesByCanteenNameServlet", urlPatterns = {"/SelectDishesByCanteenNameServlet"})
public class SelectDishesByCanteenNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        DataService dataService = new DataService();
        List<Dish> dishes = dataService.selectDishesByCanteenName(name);
        req.setAttribute("dishes", dishes);
        req.getRequestDispatcher("/selectdishbycanteenname.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
