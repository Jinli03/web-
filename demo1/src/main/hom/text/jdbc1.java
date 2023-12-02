package main.hom.text;

import main.hom.text.Chat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc1 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from  person";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Jinli03");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String work = rs.getString("work");
                int age = rs.getInt("age");
                System.out.println(name);
                System.out.println(work);
                System.out.println(age);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void insertData(String name, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 尝试加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 尝试获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Jinli03");

            // 使用 PreparedStatement，防止 SQL 注入攻击
            String sql = "INSERT INTO login (name, password) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            // 执行插入语句
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            // 处理异常
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static boolean findData(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exchange = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Jinli03");

            // Query for a person with the specified name
            String sql = "SELECT * FROM login WHERE name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            // Check if there is data
            exchange = rs.next();
            System.out.println("Exchange value: " + exchange);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Print the exception details
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        // Return true if a matching record was found, otherwise return false
        return exchange;
    }


    public static boolean verify(String name, String mima) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean exchange = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Jinli03");
            stmt = conn.createStatement();

            // Query for a person with the specified name
            String sql = "SELECT * FROM login WHERE name = '" + name + "'";
            rs = stmt.executeQuery(sql);

            // Iterate through the result set
            while (rs.next()) {
                if (name.equals(rs.getString("name")) && mima.equals(rs.getString("password"))) {
                    exchange = true;
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Return true if a matching record was found, otherwise return false
        return exchange;
    }
    public static void insertInf(String title, String name, String currenttime, String inf) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 尝试加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 尝试获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Jinli03");

            // 使用 PreparedStatement，防止 SQL 注入攻击
            String sql = "INSERT INTO  chat (title, name, currenttime, inf) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, name);
            pstmt.setString(3, currenttime);
            pstmt.setString(4, inf);
            // 执行插入语句
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            // 处理异常
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

        Connection conn = null;
        PreparedStatement pstmt = null;
    public static List<String> getDistinctTitles() {
        List<String> titles = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Jinli03");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT DISTINCT title FROM chat")) {
            while (rs.next()) {
                titles.add(rs.getString("title"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return titles;
    }
    public static List<Chat> getAllChatDetails() {
        List<Chat> chatList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Jinli03");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM chat")) {

            while (rs.next()) {
                Chat chat = new Chat();
                chat.setTitle(rs.getString("title"));
                chat.setName(rs.getString("name"));
                chat.setCurrenttime(rs.getString("currenttime"));
                chat.setInf(rs.getString("inf"));
                chatList.add(chat);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return chatList;
    }
}
