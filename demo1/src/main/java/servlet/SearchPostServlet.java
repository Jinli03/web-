package servlet;

import entity.Post;
import entity.PostComment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.PostCommentService;
import select.PostService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchPostServlet", value = "/SearchPostServlet")
public class SearchPostServlet extends HttpServlet {
    private PostService postService = new PostService();
    private PostCommentService postCommentService=new PostCommentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");

        // 实现搜索逻辑，这里需要按searchQuery从数据库检索帖子
        List<Post> posts = postService.searchPosts(searchQuery);

        // 将结果设置到request属性中，以便可以在JSP中显示
         request.setAttribute("posts", posts);
        // 创建一个映射，将每个帖子的ID映射到其评论列表
        Map<Integer, List<PostComment>> commentsMap = new HashMap<>();

        // 对于每个帖子，获取它的评论并放入映射中
        for (Post post : posts) {
            List<PostComment> comments = postCommentService.getPostComments(post.getId());
            commentsMap.put(post.getId(), comments);
        }

        // 将评论映射设置到请求属性中
        request.setAttribute("commentsMap", commentsMap);

        // 转发请求到显示搜索结果的JSP页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("search_results.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
