package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://116.204.101.203:3306/userinfo";
    private static final String JDBC_USER = "userInfo";
    private static final String JDBC_PASSWORD = "213506usst";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.getWriter().write("Error loading MySQL JDBC driver");
            return;
        }

        // Database connection and query
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM Demo WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // User found in the Demo table
                        // You can do further processing here
                        resp.getWriter().write("Login successful");
                        System.out.println(username);
                        System.out.println(password);
                        System.out.println("success");
                    } else {
                        // User not found in the Demo table
                        resp.getWriter().write(createJsonResponse(false));
                        System.out.println("fail");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Error connecting to the database");
        }
    }

    private String createJsonResponse(boolean success) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        return mapper.writeValueAsString(responseMap);
    }
}
