package servlet;

import dao.VoteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String v1 = request.getParameter("v1");
        String v2 = request.getParameter("v2");
        String v3 = request.getParameter("v3");
        String v4 = request.getParameter("v4");
        String v5 = request.getParameter("v5");

        VoteDAO vd=new VoteDAO();
        vd.updateVoteCount(v1,"q1");
        vd.updateVoteCount(v2,"q2");
        vd.updateVoteCount(v3,"q3");
        vd.updateVoteCount(v4,"q4");
        vd.updateVoteCount(v5,"q5");



        Map<String, Integer[]> voteCounts = vd.getVoteCounts();

        // 检查 voteCounts 是否为空或没有数据
        if (voteCounts == null || voteCounts.isEmpty()) {
            System.out.println("voteCounts is null or empty.");
        } else {
            // 遍历并打印出 map 中的数据
            for (Map.Entry<String, Integer[]> entry : voteCounts.entrySet()) {
                System.out.println("Comment: " + entry.getKey());
                System.out.print("Votes: ");
                for (Integer vote : entry.getValue()) {
                    System.out.print(vote + " ");
                }
                System.out.println(); // 新行
            }
        }
        request.setAttribute("voteCounts", voteCounts); // 将数据添加到请求属性中
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("VoteResult.jsp");
        dispatcher2.forward(request, response); // 转发请求到 JSP 页面



    }
}

