package jdbc.dao_.test;



import jdbc.dao_.dao.UserDao;
import jdbc.dao_.pojo.User;

import java.util.List;

/**
 * @time 2022/5/27 21:27 星期五
 * 测试Dao
 */
public class DaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        List<User> users = userDao.queryMulti("select * from users where id >= ?", User.class, 2);
        users.forEach(System.out::println);

        User user = userDao.querySingle("select username, userpassword FROM users WHERE id = ?", User.class, 1);
        System.out.println(user.getUserName() + user.getUserPassword());

        Object num = userDao.queryScalar("SELECT COUNT(*) FROM users", (Object[]) null);
        System.out.println(num);

    }
}
