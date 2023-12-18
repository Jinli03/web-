package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;
import entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public void insertPost(Post post) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO posts (title, content, author) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Executing SQL: " + sql); // 调试语句

            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getAuthor());

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


    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM posts";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String author = resultSet.getString("author");
                Timestamp timestamp = resultSet.getTimestamp("datePosted");
                Date datePosted = (timestamp != null) ? new Date(timestamp.getTime()) : null;
                Post post = new Post(id, title, content, author);
                post.setDatePosted(datePosted);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResultSet(resultSet);
            //JDBCUtils.closeStatement(statement);
            JDBCUtils.closeConnection(connection);
        }
    //    System.out.println("getAllPosts called, number of posts: " + posts.size());

        return posts;
    }

    public List<Post> searchPosts(String query) {
        List<Post> searchResults = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 连接数据库
            connection = JDBCUtils.getConnection();

            // 创建SQL查询，使用LIKE运算符进行模糊匹配
            String sql = "SELECT * FROM posts WHERE title LIKE ? OR author LIKE ?";
            preparedStatement = connection.prepareStatement(sql);

            // 为防止SQL注入，使用PreparedStatement设置参数
            preparedStatement.setString(1, "%" + query + "%");
            preparedStatement.setString(2, "%" + query + "%");

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            // 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String author = resultSet.getString("author");
                Timestamp datePosted = resultSet.getTimestamp("datePosted");

                // 创建Post对象并添加到列表中
                Post post = new Post();
                post.setId(id);
                post.setTitle(title);
                post.setContent(content);
                post.setAuthor(author);
                post.setDatePosted(new Date(datePosted.getTime())); // 转换Timestamp为Date
                searchResults.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 在实际应用中应有更好的异常处理
        } finally {
            // 关闭资源
            JDBCUtils.closeResultSet(resultSet);
            JDBCUtils.closeStatement(preparedStatement);
            JDBCUtils.closeConnection(connection);
        }
        return searchResults;
    }
}
