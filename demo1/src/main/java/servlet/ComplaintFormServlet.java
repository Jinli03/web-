package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ComplaintFormServlet", value = "/ComplaintFormServlet")
public class ComplaintFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String canteen = request.getParameter("canteen");
        String dish = request.getParameter("dish");

        request.setAttribute("canteen", canteen);
        request.setAttribute("dish", dish);

        RequestDispatcher dispatcher = request.getRequestDispatcher("complaintForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
