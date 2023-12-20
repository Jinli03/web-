package dao;

import entity.Complaint;
import util.JDBCUtils;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComplaintDao {
    public void addComplaint(Complaint complaint) {
        // 使用 JDBC 执行 SQL 插入操作
        // 确保设置了title, details, username, canteen, 和 dish
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO complaints (title, details, username, canteen, dish) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Executing SQL: " + sql); // 调试语句

            preparedStatement.setString(1, complaint.getTitle());
            preparedStatement.setString(2, complaint.getDetails());
            preparedStatement.setString(3, complaint.getUsername());
            preparedStatement.setString(4, complaint.getCanteen());
            preparedStatement.setString(5, complaint.getDish());


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
}
