package jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.Properties;

/**
 * @time 2022/5/22 21:48 星期日
 * 连接MySQL的5种方式
 */
public class ConnectJdbc {
    //为减少重复代码，写此类变量
    private static final String url = "jdbc:mysql://localhost:3306/test";
    //为减少重复代码，写此方法
    private Properties getProperties() {
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");
        return info;
    }
    //为减少重复代码，写此方法
    private void extracted(Connection connect) throws SQLException {
        //3:执行SQL
        //Statement statement = connect.createStatement();
        //ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        //Statement存在SQL注入问题、拼接字符串不方便；
        //PrepareStatement可以操作 Blob 数据、可以实现更高效的批量操作
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM users ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + "\t");
            System.out.print(resultSet.getString(2) + "\t");
            System.out.println(resultSet.getString(3));
        }
        //关闭连接
//        statement.close();
        preparedStatement.close();
        resultSet.close();
        connect.close();
    }

    @Test
    public void Test1() throws Exception {
        //1:注册驱动
        Driver driver = new Driver();
        //2:得到连接
        Properties info = getProperties();
        Connection connect = driver.connect(url, info);

        //这个方法写在最面了
        extracted(connect);
    }

    @Test
    public void Test2() throws Exception {
        //1:注册驱动 (使用反射更加灵活)
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        //Driver driver = (Driver) aClass.newInstance();    //newInstance()已过时
        Constructor<?> constructor = aClass.getConstructor();
        Driver driver = (Driver) constructor.newInstance();
        //2:得到连接
        Properties info = getProperties();
        Connection connect = driver.connect(url, info);

        //这个方法写在最前面了
        extracted(connect);
    }

    @Test
    public void Test3() throws Exception {
        //1:注册驱动 (使用反射更加灵活)
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //使用Java内置的API进行注册连接
        DriverManager.registerDriver(driver);
        //2:得到连接(此方式更为灵活，不必创建Properties对象)
        String user = "root";
        String password = "root";
        Connection connect = DriverManager.getConnection(url, user, password);

        //这个方法写在最前面了
        extracted(connect);
    }

    @Test
    public void Test4() throws Exception {
        //1:注册驱动 （使用Class.forName自动完成）
        //在加载Driver类时，自动完成注册（参考源码）
        //推荐使用这个方式！！！
        /*
        * static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
        * */
        //在mysql驱动5.1.6之后，自动调用META-INF\services\java.sql.Driver文本中的类名称注册
        //这句话可以省略，但还是建议写这句话以更加明确！！！
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2:得到连接(此方式更为灵活，不必创建Properties对象)
        String user = "root";
        String password = "root";
        Connection connect = DriverManager.getConnection(url, user, password);

        //这个方法写在最前面了
        extracted(connect);
    }

    //方式5，在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
    //推荐使用方式5！！！
    @Test
    public void Test5() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("JDBC\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        extracted(connection);
    }
}
