package jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @time 2022/5/23 21:05 星期一
 */
public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("JDBC\\mysql.properties"));
            //读取相关属性值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，可以这样处理
            //将编译异常转成运行异常
            //此时调用者可以选择 捕获 ，也可以选择抛出该异常
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

