package servlet;

import dao.PostDao;
import entity.Post;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.PostService;

import java.io.IOException;

@WebServlet(name = "GetImageServlet", value = "/GetImageServlet")
public class GetImageServlet extends HttpServlet {
    private PostService postService = new PostService(); // 确保PostService有方法getPostById

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postIdStr = request.getParameter("postId");
        if (postIdStr != null) {
            int postId = Integer.parseInt(postIdStr);
            Post post = postService.getPostById(postId);
            if (post != null && post.getImage() != null) {
                response.setContentType("image/jpeg"); // 或者根据实际图片类型设置
                response.getOutputStream().write(post.getImage());
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND); // 找不到图片时的处理
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
