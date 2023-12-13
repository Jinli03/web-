package servlet;

import entity.Dish;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;

@WebServlet("/SelectSingleDishServlet")
public class SelectSingleDishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search=request.getParameter("search");
        DataService data=new DataService();
        Dish dish=data.selectDishesByUserid(search);
        request.setAttribute("dish",dish);
        request.getRequestDispatcher("SelectDishesByid.jsp").forward(request,response);
    }

    }
