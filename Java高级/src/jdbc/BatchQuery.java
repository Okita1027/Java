package jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @time 2022/5/27 15:16 星期五
 * 批处理:能够大幅减少磁盘IO，减少数据库访问次数，提高程序执行效率
 */
public class BatchQuery {
    @Test
    public void batchTest() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (int i = 0; i < 100000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.addBatch();
            if (i % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        preparedStatement.executeBatch();
        JDBCUtilsByDruid.close(null, preparedStatement, conn);
    }
}
