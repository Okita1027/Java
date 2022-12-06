package jdbc.dao_.dao;

import jdbc.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @time 2022/5/27 15:39 星期五
 * 通用的Dao类
 */
public class BasicDao<T> {

    private final QueryRunner qr = new QueryRunner();
    private Connection conn = null;

    public int update(String sql, Object... parameters) {
        int affectRow = 0;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            affectRow = qr.update(conn, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }
        return affectRow;
    }

    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        List<T> list = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            list = qr.query(conn, sql, new BeanListHandler<>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }
        return list;
    }

    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return qr.query(conn, sql, new BeanHandler<>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }
    }

    public Object queryScalar(String sql, Object... parameters) {
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return qr.query(conn, sql, new ScalarHandler<>(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }
    }

}
