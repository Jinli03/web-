package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;

@WebServlet("/DeleteDishServlet")
public class DeleteDishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputId=request.getParameter("inputId");

        DataService data=new DataService();
        data.deleteDishes(inputId);

        response.sendRedirect("DeleteDish.html");


    }
}
