package servlet;

import entity.Canteen;
import entity.Comment;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddDishCommentByIdServlet", urlPatterns = {"/AddDishCommentByIdServlet"})
public class AddDishCommentByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String cperson = (String) servletContext.getAttribute("username");
        String canteen = req.getParameter("canteen");
        String dish = req.getParameter("dish");
        String cmessage = req.getParameter("cmessage");
        String gradeString = req.getParameter("grade");
        float grade = 0.0f;  // 默认值可以根据实际情况设置

        try {
            if (gradeString != null && !gradeString.isEmpty()) {
                grade = Float.parseFloat(gradeString);
            }
        } catch (NumberFormatException e) {
            // 处理无法解析为浮点数的情况，可以设置默认值或者进行其他错误处理
            e.printStackTrace();  // 记录异常以便调试
        }
        DataService dataService = new DataService();
        Comment comment = new Comment();
        comment.setCanteen(canteen);
        comment.setDish(dish);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        comment.setTime(currentTime);
        comment.setCperson(cperson);
        comment.setCmessage(cmessage);
        comment.setGrade(grade);
        dataService.addDishCommentById(comment);
        String id = (String) servletContext.getAttribute("id");
        float avegrade = dataService.queryDishAvarageGradeById(id);
        int roundedAveGrade = (int) avegrade;
        dataService.updateDishAverageGradeById(id,roundedAveGrade);
        req.getRequestDispatcher("/SelectAllDishesByServlet").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
