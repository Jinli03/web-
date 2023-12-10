package servlet;

import entity.Canteen;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
@WebServlet(name = "SelectCanteenByNameServlet", urlPatterns = {"/SelectCanteenByNameServlet"})
public class SelectCanteenByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        DataService dataService = new DataService();
        Canteen canteen = dataService.selectCanteenByName(name);
        req.setAttribute("canteen",canteen);
        System.out.println(canteen);
        req.getRequestDispatcher("/updatecanteen.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}