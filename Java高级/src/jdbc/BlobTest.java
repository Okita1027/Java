package jdbc;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * @time 2022/5/23 22:09 星期一
 * 利用PreparedStatement插入Blob（二进制）型数据 -> 涩图
 */
public class BlobTest {
    @Test
    public void insertBlob() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "INSERT INTO images values(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 2);
        preparedStatement.setBlob(2, new FileInputStream("JDBC\\setu.png"));
        preparedStatement.execute();
        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void test() {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println("format = " + format);
        System.out.println("Math.rint(1.2) = " + Math.rint(1.2));
        System.out.println("Math.rint(1.2) = " + Math.rint(2.2));
        System.out.println("Math.rint(1.2) = " + Math.rint(2.6));
        System.out.println("Math.rint(1.2) = " + Math.rint(1.5));
        System.out.println("Math.rint(1.2) = " + Math.rint(2.5));
        System.out.println("==================================");
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println("Math.log(1) = " + Math.log(122333));
        double d = 1.2;
        System.out.println((int) d);
        long l = 1234567890;
        System.out.println((int) l);



    }

}
