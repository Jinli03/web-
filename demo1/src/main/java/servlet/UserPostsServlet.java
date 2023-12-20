package servlet;

import entity.Post;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserPostsServlet", value = "/UserPostsServlet")
public class UserPostsServlet extends HttpServlet {
    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        List<Post> posts = postService.getPostsByUser(username);
        request.setAttribute("posts", posts);
        request.setAttribute("username", username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("userPosts.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
