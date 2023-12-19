package dao;


import entity.PostComment;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostCommentDao {
    // 方法来添加评论到数据库
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public void addComment(PostComment postcomment) {
        // 假设您已经有一个方法来获取数据库连接: getConnection()
        String sql = "INSERT INTO postcomments (postId, username, content) VALUES (?, ?, ?)";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, postcomment.getPostId());
            pstmt.setString(2, postcomment.getUsername());
            pstmt.setString(3, postcomment.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 方法来获取帖子的所有评论
    public List<PostComment> getCommentsByPostId(int postId) {
        List<PostComment> comments = new ArrayList<>();
        String sql = "SELECT * FROM postcomments WHERE postId = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, postId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PostComment postcomment = new PostComment();
                    postcomment.setId(rs.getInt("id"));
                    postcomment.setPostId(rs.getInt("postId"));
                    postcomment.setUsername(rs.getString("username"));
                    postcomment.setContent(rs.getString("content"));
                    postcomment.setDatePosted(rs.getTimestamp("datePosted"));
                    comments.add(postcomment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}