package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class VoteDAO {

    public void updateVoteCount(String value,String column) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "";
            if (value.equals("1")) {
                sql = "UPDATE votes SET " + column + " = " + column + " + 1 WHERE comment = '1'";
            } else if (value.equals("2")) {
                sql = "UPDATE votes SET " + column + " = " + column + " + 1 WHERE comment = '2'";
            } else if (value.equals("3")) {
                sql = "UPDATE votes SET " + column + " = " + column + " + 1 WHERE comment = '3'";
            } else if (value.equals("4")) {
                sql = "UPDATE votes SET " + column + " = " + column + " + 1 WHERE comment = '4'";
            }

            if (!sql.isEmpty()) {
                preparedStatement = connection.prepareStatement(sql);

                // 调试语句
                System.out.println("Executing SQL: " + sql);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected); // 调试语句
            }
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




    public Map<String, Integer[]> getVoteCounts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT comment, q1, q2, q3, q4, q5 FROM votes WHERE comment IN ('1', '2', '3', '4')";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            Map<String, Integer[]> voteCounts = new HashMap<>();
            while (resultSet.next()) {
                String comment = resultSet.getString("comment");
                Integer[] counts = {
                        resultSet.getInt("q1"),
                        resultSet.getInt("q2"),
                        resultSet.getInt("q3"),
                        resultSet.getInt("q4"),
                        resultSet.getInt("q5")
                };
                voteCounts.put(comment, counts);
            }
            return voteCounts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.closeConnection(connection);
            JDBCUtils.closeResultSet(resultSet);
            JDBCUtils.closePreparedStatement(preparedStatement);
        }
    }

}


