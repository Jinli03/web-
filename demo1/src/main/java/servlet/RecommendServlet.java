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

@WebServlet("/RecommendServlet")
public class RecommendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        DataService data=new DataService();
        List<Dish> d= data.selectAllDishes();

        System.out.println("dadadadad");

        request.setAttribute("AllDishes",d);
        request.getRequestDispatcher("Recommend.jsp").forward(request, response);

    }

}
