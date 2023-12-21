package servlet;

import entity.Post;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.PostService;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "CreatePostServlet", value = "/CreatePostServlet")
@MultipartConfig
public class CreatePostServlet extends HttpServlet {
    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part imagePart = request.getPart("image"); // 获取图片部分
        InputStream imageInputStream = imagePart.getInputStream();
        byte[] imageBytes = imageInputStream.readAllBytes();

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        ServletContext servletContext = request.getServletContext();
        String author = (String) servletContext.getAttribute("username");  //

        // 验证author是否不为空
        if (author == null || author.trim().isEmpty()) {
            // 处理未认证用户的情况或跳转到登录页面
            response.sendRedirect("index.jsp");
            return;
        }

        // 根据需要创建Post对象
        //Post post = new Post(title, content, author);

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        post.setImage(imageBytes); // 设置图片数据
        // 调用Service层处理业务
        postService.insertPost(post);
        // 重定向或转发
        response.sendRedirect("/demo1_war_exploded/GetAllPostsServlet");
    }
}
