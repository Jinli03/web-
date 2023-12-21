package servlet;


import entity.Complaint;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.ComplaintService;

import java.io.IOException;
import java.util.List;

@WebServlet("/replyServlet")
public class replyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取回复内容并创建Complaint对象，将属性添加
        String reply=request.getParameter("reply");
        String title=request.getParameter("title");
        Complaint complaint=new Complaint();
        complaint.setReply(reply);
        complaint.setTitle(title);

        System.out.println("hhhhhhhhhhhhhhhh"+reply);

        // 更新 Complaint 对象的 replied 属性为 true
        complaint.setReplied(1);

        //获取用户名
        ServletContext servletContext=request.getServletContext();
        String responder=(String) servletContext.getAttribute("username");
        complaint.setResponder(responder);

        //将complaint添加到数据库
        ComplaintService cps=new ComplaintService();
        cps.addReply(complaint);

        //统计未读投诉消息的数量
        int count=cps.count();
        request.setAttribute("count",count);

        System.out.println("llllll"+count);


        request.getRequestDispatcher("Cafeteria.jsp").forward(request, response);



    }
}
