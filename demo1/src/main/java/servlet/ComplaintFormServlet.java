package servlet;

import entity.Complaint;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.ComplaintService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ComplaintFormServlet", value = "/ComplaintFormServlet")
public class ComplaintFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String canteen = request.getParameter("canteen");
        String dish = request.getParameter("dish");

        request.setAttribute("canteen", canteen);
        request.setAttribute("dish", dish);


        //获取回复的投诉消息
        ComplaintService cps=new ComplaintService();
        List<Complaint> c=cps.selectAllComplaints();
        request.setAttribute("complaints",c);

        System.out.println(c);

        //用于判断为哪个用户的回复消息
        Complaint cc=new Complaint();
        ServletContext servletContext = request.getServletContext();
        String username = (String) servletContext.getAttribute("username");
        cc.setUsername(username); // 使用 ServletContext 获取的用户名
        request.setAttribute("judge",cc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("complaintForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
