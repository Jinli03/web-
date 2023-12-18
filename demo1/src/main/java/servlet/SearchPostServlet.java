package servlet;

import entity.Post;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchPostServlet", value = "/SearchPostServlet")
public class SearchPostServlet extends HttpServlet {
    private PostService postService = new PostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");

        // 实现搜索逻辑，这里需要按searchQuery从数据库检索帖子
        List<Post> posts = postService.searchPosts(searchQuery);

        // 将结果设置到request属性中，以便可以在JSP中显示
         request.setAttribute("posts", posts);

        // 转发请求到显示搜索结果的JSP页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("search_results.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
