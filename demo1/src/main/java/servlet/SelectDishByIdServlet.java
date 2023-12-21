package servlet;

import entity.Canteen;
import entity.Dish;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;

@WebServlet(name = "SelectDishByIdServlet", urlPatterns = {"/SelectDishByIdServlet"})
public class SelectDishByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("id", id);
        DataService dataService = new DataService();
        Dish dish = dataService.selectDishById(id);
        req.setAttribute("dish",dish);
        System.out.println(dish);
        req.getRequestDispatcher("/adddishcomment.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
