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

@WebServlet("/SelectAllDishesServlet")
public class SelectAllDishesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        DataService data=new DataService();
        List<Dish> d= data.selectAllDishes();

        request.setAttribute("AllDishes",d);
        request.getRequestDispatcher("SelectAllDishes.jsp").forward(request,response);

    }

}
