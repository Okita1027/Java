package test.iterator;

/**
 * @Author qzy
 * @ClassName UserAggregate
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 19:44 星期四
 */
public interface UserAggregate {
    void addUser(User user);

    void removeUser(int index);

    UserIterator getUserIterator();
}
