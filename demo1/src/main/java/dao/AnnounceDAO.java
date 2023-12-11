package dao;

import entity.Announce;
import entity.Cafeteria;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AnnounceDAO {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());



    public void save_announce(String title, String time,String content) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO ads (title, time,content) VALUES (?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Executing SQL: " + sql); // 调试语句

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, time);
            preparedStatement.setString(3, content);

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



    public List<Announce> getAllAnnounce() {
        try {
            String sql = "SELECT * FROM ads ORDER BY id DESC";
            return template.query(sql, new BeanPropertyRowMapper<>(Announce.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
