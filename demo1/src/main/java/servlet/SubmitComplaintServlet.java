package servlet;

import dao.ComplaintDao;
import entity.Complaint;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.ComplaintService;

import java.io.IOException;

@WebServlet(name = "SubmitComplaintServlet", value = "/SubmitComplaintServlet")
public class SubmitComplaintServlet extends HttpServlet {
    private ComplaintService complaintservice=new ComplaintService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Complaint complaint = new Complaint();
        complaint.setTitle(request.getParameter("title"));
        complaint.setDetails(request.getParameter("details"));
        ServletContext servletContext = request.getServletContext();
        String username = (String) servletContext.getAttribute("username");
        complaint.setUsername(username); // 使用 ServletContext 获取的用户名
        String canteen = request.getParameter("canteen");
        String dish = request.getParameter("dish");
        complaint.setCanteen(canteen);
        complaint.setDish(dish);
        complaintservice.addComplaint(complaint);
        response.sendRedirect("complaintForm.jsp");
    }
}
