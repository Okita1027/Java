package jdbc;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @time 2022/5/27 13:58 星期五
 * 德鲁伊连接池工具类02
 */
public class DBUtilsTest {
    @Test
    public void queryAllTest() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM users WHERE id >= ?";
        // 多行结果
        List<Users> list = queryRunner.query(conn, sql, new BeanListHandler<>(Users.class), 2);
        list.forEach(System.out::println);
        DbUtils.close(conn);
    }

    @Test
    public void querySingleTest() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM users WHERE id = ?";
        // 单行结果
        Users user = queryRunner.query(conn, sql, new BeanHandler<>(Users.class), 2);
        System.out.println(user);
        DbUtils.close(conn);
    }

    @Test
    public void queryScalarTest() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT username FROM users WHERE id = ?";
        //单列结果
        Object username = queryRunner.query(conn, sql, new ScalarHandler(),  1);
        System.out.println(username);
        JDBCUtilsByDruid.close(null, null, conn);
    }

    @Test
    public void updateTest() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE users SET username = ? WHERE id = ?";
        // update方法不仅能修改，也可以进行插入、删除操作
        int affectRow = queryRunner.update(conn, sql, "QZY", 1);
        System.out.println(affectRow > 0 ? "修改成功！" : "未能造成影响！");
        JDBCUtilsByDruid.close(null, null, conn);
    }

}
