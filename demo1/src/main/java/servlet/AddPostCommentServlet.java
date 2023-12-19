package servlet;

import entity.PostComment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.PostCommentService;
import select.PostService;

import java.io.IOException;

@WebServlet(name = "AddPostCommentServlet", value = "/AddPostCommentServlet")
public class AddPostCommentServlet extends HttpServlet {
    private PostCommentService postcommentService = new PostCommentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        ServletContext servletContext = request.getServletContext();
        String username = (String) servletContext.getAttribute("username");

        String content = request.getParameter("content");

        PostComment postcomment = new PostComment();
        postcomment.setPostId(postId);
        postcomment.setUsername(username);
        postcomment.setContent(content);


        postcommentService.addPostComment(postcomment);

        // 重定向回帖子详情页面，或者其他逻辑
        response.sendRedirect("GetAllPostsServlet?postId=" + postId); // 假设这是帖子详情页面的URL
    }
}
