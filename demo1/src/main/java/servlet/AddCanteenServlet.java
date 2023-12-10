package servlet;

import entity.Canteen;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
@WebServlet(name = "AddCanteenServlet", urlPatterns = {"/AddCanteenServlet"})
public class AddCanteenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        String name = req.getParameter("name");
        String time = req.getParameter("time");
        String position = req.getParameter("position");
        Canteen canteen = new Canteen();
        canteen.setName(name);
        canteen.setTime(time);
        canteen.setPosition(position);
        dataService.addCanteen(canteen);
        req.getRequestDispatcher("/QueryCanteenServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}