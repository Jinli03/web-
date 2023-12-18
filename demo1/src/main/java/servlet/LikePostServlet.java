package servlet;

import dao.PostDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LikePostServlet", value = "/LikePostServlet")
public class LikePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        PostDao postDao = new PostDao();
        postDao.increaseLike(postId);
        // 重定向回帖子页面或执行其他操作
        response.sendRedirect( "/demo1_war_exploded/GetAllPostsServlet");
    }
}
