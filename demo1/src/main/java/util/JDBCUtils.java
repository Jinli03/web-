package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//JDBC工具类，使用Durid连接池
public class JDBCUtils {

    static{
        try {
            Properties pro = new Properties();
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static DataSource ds;
    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    //获取Connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
