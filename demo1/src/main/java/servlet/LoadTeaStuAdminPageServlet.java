package servlet;

import entity.Post;
import entity.Tsuser;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import select.DataService;
import select.PostService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoadTeaStuAdminPageServlet", value = "/LoadTeaStuAdminPageServlet")
public class LoadTeaStuAdminPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String username = req.getParameter("username");
        DataService dataService = new DataService();

        int times = dataService.selectTsTimes(username);
        times = times + 1;
        dataService.updateTsTimes(username,times);
        List<Tsuser> tsuser = new ArrayList<Tsuser>();
        tsuser = dataService.selectAllTsuserAndTimes();
        System.out.println(tsuser);
        req.setAttribute("tsuser",tsuser);
        req.setAttribute("username",username);

        PostService postService=new PostService();
        List<Post> hotTopics = postService.getHotTopics();
        req.setAttribute("hotTopics", hotTopics);

        req.getRequestDispatcher("/tea_stu_admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
