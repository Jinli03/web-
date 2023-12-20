package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;
import entity.Post;

import java.io.ByteArrayInputStream;
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
            String sql = "INSERT INTO posts (title, content, author,image) VALUES (?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Executing SQL: " + sql); // 调试语句

            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getAuthor());
            if (post.getImage() != null) {
                preparedStatement.setBlob(4, new ByteArrayInputStream(post.getImage()));
            } else {
                preparedStatement.setBlob(4, (Blob) null);
            }
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
                int likes=resultSet.getInt("likes");
                Date datePosted = (timestamp != null) ? new Date(timestamp.getTime()) : null;
                Post post = new Post(id, title, content, author);
                post.setDatePosted(datePosted);
                post.setLikes(likes);
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
                int likes=resultSet.getInt("likes");
                // 创建Post对象并添加到列表中
                Post post = new Post();
                post.setId(id);
                post.setTitle(title);
                post.setContent(content);
                post.setAuthor(author);
                post.setDatePosted(new Date(datePosted.getTime())); // 转换Timestamp为Date
                post.setLikes(likes);
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

    public void increaseLike(int postId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE posts SET likes = likes + 1 WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, postId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
    }
    public Post getPostById(int postId) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        Post post = null;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, postId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    post = new Post();
                    post.setId(rs.getInt("id"));
                    post.setTitle(rs.getString("title"));
                    post.setContent(rs.getString("content"));
                    post.setImage(rs.getBytes("image")); // 假设您有一个 image 字段
                    // ... 设置其他的属性，比如作者等
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
    public List<Post> getAllPostsSorted(String sortBy) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts ";
        if ("heat".equals(sortBy)) {
            sql += "ORDER BY likes DESC";
        } else if("time".equals(sortBy)){
            sql += "ORDER BY datePosted DESC";
        }

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {


                              int id = resultSet.getInt("id");
                         String title = resultSet.getString("title");
                            String content = resultSet.getString("content");
                         String author = resultSet.getString("author");
                              Timestamp timestamp = resultSet.getTimestamp("datePosted");
                        int likes=resultSet.getInt("likes");
                        Date datePosted = (timestamp != null) ? new Date(timestamp.getTime()) : null;
                            Post post = new Post(id, title, content, author);
                             post.setDatePosted(datePosted);
                           post.setLikes(likes);
                              posts.add(post);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
