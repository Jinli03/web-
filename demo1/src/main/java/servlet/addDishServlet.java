package servlet;

import entity.Dish;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import select.DataService;

import java.io.IOException;


@WebServlet("/addDishServlet")
public class addDishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取元素
        String imageName=request.getParameter("imageName");
        String dishName=request.getParameter("dishName");
        String cuisine=request.getParameter("cuisine");
        String price1=request.getParameter("price");
        String ratings=request.getParameter("rating");
        String canteen=request.getParameter("canteen");

        float rating,price;
        rating = Float.parseFloat(ratings);//强制转换为float类型
        price=Float.parseFloat(price1);

       //给dish设置属性
        Dish dish=new Dish();
        dish.setPicture(imageName);
        dish.setId(dishName);
        dish.setKind(cuisine);
        dish.setPrice(price);
        dish.setGrade(rating);
        dish.setCanteen(canteen);

        DataService data=new DataService();
        data.addDishes(dish);


        response.sendRedirect("addDish.html");




    }

}
