package servlet;

import dao.AnnounceDAO;
import entity.Announce;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/AnnouncementServlet")
public class AnnouncementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String time = request.getParameter("time");
        String content = request.getParameter("content");

        AnnounceDAO announceDAO=new AnnounceDAO();
        announceDAO.save_announce(title,time,content);
        List<Announce> a=announceDAO.getAllAnnounce();

        request.setAttribute("announce",a);
        request.setAttribute("title", title);
        request.setAttribute("time", time);
        request.setAttribute("import javax.servlet.http.*;content", content);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Cafeteria.jsp");
        dispatcher.forward(request, response);
    }
}

