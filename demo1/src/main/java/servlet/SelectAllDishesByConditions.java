package servlet;

import entity.Dish;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.ReactiveAdapterRegistry;
import select.DataService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllDishesByConditionsServlet", urlPatterns = {"/SelectAllDishesByConditionsServlet"})
public class SelectAllDishesByConditions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        try {
            String kind = req.getParameter("kind");
            String priceString = req.getParameter("price");
            float price = 0;

            // 在解析之前检查 priceString 是否不为 null 且不是空字符串
            if (priceString != null && !priceString.isEmpty()) {
                price = Float.parseFloat(priceString);
            }

            String canteen = req.getParameter("canteen");

            Dish dish = new Dish();
            dish.setKind(kind);
            dish.setPrice(price);
            dish.setCanteen(canteen);

            req.setAttribute("dish", dish);

            List<Dish> dishes = dataService.selectAllDishesByConditions(dish);
            req.setAttribute("dishes", dishes);

            System.out.println(kind);
            System.out.println(price);
            System.out.println(canteen);
            System.out.println(dishes);

        } catch (NumberFormatException e) {
            // 处理无法将 priceString 解析为浮点数的情况
            // 你可能想设置默认值或显示错误消息
            e.printStackTrace();  // 记录异常以便调试
        }

        req.getRequestDispatcher("/selectdishbycondition.jsp").forward(req, resp);
    }

        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
        }

    }