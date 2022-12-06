package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @time 2022/5/25 21:26 星期三
 * JDBC之 C3P0 连接池
 */
public class C3P0Test {
    @Test
    public void C3P0test01() throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileReader("JDBC\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driver);

        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接完毕！");
        connection.close();
    }

    @Test
    public void C3P0test02() throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接完毕！");
        connection.close();
    }
}
