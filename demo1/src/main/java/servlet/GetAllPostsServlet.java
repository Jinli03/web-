package servlet;

import dao.PostDao;
import entity.Post;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllPostsServlet", value = "/GetAllPostsServlet")
public class GetAllPostsServlet extends HttpServlet {
    private PostService postService = new PostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Post> posts = postService.getAllPosts();
        request.setAttribute("posts", posts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("community.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
