package select;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import entity.Cuser;
import org.springframework.util.RouteMatcher;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Query {
    public static void query() throws Exception{
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/AndroidStudioProjects/MyApplication2/web-/demo1/src/resources/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        String sql = "select * from canteen_manager";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Cuser> cuserlist = new ArrayList<>();
        while (rs.next()){
            String username = rs.getString("username");
            String canteen = rs.getString("canteen");
            Cuser cuser = new Cuser();
            cuser.setUsername(username);
            cuser.setCanteen(canteen);
            cuserlist.add(cuser);
            System.out.println(username);
            System.out.println(canteen);
        }
        System.out.println(cuserlist);
        rs.close();
        pstmt.close();
        conn.close();

    }
}
