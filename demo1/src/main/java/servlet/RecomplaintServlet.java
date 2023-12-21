package servlet;


import entity.Complaint;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.ComplaintService;

import java.io.IOException;
import java.util.List;

@WebServlet("/RecomplaintServlet")
public class RecomplaintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        ComplaintService cps= new ComplaintService();
        List<Complaint> c= cps.selectAllComplaints();
        request.setAttribute("complaints",c);

        request.getRequestDispatcher("Re_complaints.jsp").forward(request, response);


    }
}
