package jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @time 2022/5/26 20:53 星期四
 * JDBC之 Druid(德鲁伊) 连接池
 */
public class DruidTest {
    @Test
    public void druidTest() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("JDBC/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功！");
        connection.close();
    }

}
