package dao;

import entity.Cafeteria;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CafeteriaDAO {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    // 保存食堂信息的方法
    public void saveCafeteriaInfo(String description, String hours) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO cafeteria (description, hours) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Executing SQL: " + sql); // 调试语句

            preparedStatement.setString(1, description);
            preparedStatement.setString(2, hours);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected); // 调试语句
        } catch (SQLException e) {
            e.printStackTrace(); // 打印异常堆栈信息
        } finally {
            // 关闭资源
            JDBCUtils.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // 获取食堂信息的方法
    public Cafeteria getCafeteriaInfo() {
        try {
            String sql = "SELECT * FROM cafeteria ORDER BY id  DESC LIMIT 1"; // 假设每次只获取最新的记录
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Cafeteria.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

