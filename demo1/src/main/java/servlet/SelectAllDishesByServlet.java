package servlet;

import entity.Dish;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllDishesByServlet", urlPatterns = {"/SelectAllDishesByServlet"})
public class SelectAllDishesByServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String kind = req.getParameter("kind");
//        String priceString = req.getParameter("price");
//        float price = 0;
//        try {
//            price = Float.parseFloat(priceString);
//            // 现在 'price' 包含浮点数值
//            // 你可以在这里使用 'price' 进行逻辑处理
//        } catch (NumberFormatException e) {
//            // 处理输入不是有效浮点数的情况
//            // 例如，你可能想设置默认值或显示错误消息
//            e.printStackTrace(); // 记录异常以便调试
//        }
//        String canteen = req.getParameter("canteen");
//        Dish dish = new Dish();
//        dish.setKind(kind);
//        dish.setPrice(price);
//        dish.setCanteen(canteen);
//        req.setAttribute("dish",dish);
        DataService dataService = new DataService();
        List<Dish> dishes =  dataService.selectAllDishes();
        req.setAttribute("dishes",dishes);
        System.out.println(dishes);
        req.getRequestDispatcher("/selectdishbycondition.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
