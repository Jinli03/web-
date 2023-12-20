package servlet;

import dao.CafeteriaDAO;
import entity.Cafeteria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Edit_cafeteria")
public class Edit_cafeteria<BasicDataSource> extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cafeteriaDescription = request.getParameter("111");
        String openingHours = request.getParameter("222");


        CafeteriaDAO cafeteriaDAO = new CafeteriaDAO();
        cafeteriaDAO.saveCafeteriaInfo(cafeteriaDescription, openingHours);
        Cafeteria cafeteriaInfo = cafeteriaDAO.getCafeteriaInfo();

        request.setAttribute("cafeteria", cafeteriaInfo); // 将信息添加到请求属性中
        request.getRequestDispatcher("Cafeteria.jsp").forward(request, response); // 转发到JSP页面
    }



    }

