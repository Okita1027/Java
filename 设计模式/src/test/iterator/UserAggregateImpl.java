package test.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName UserAggregateImpl
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 19:45 星期四
 */
public class UserAggregateImpl implements UserAggregate{
    private final List<User> userList = new ArrayList<>();

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void removeUser(int index) {
        userList.remove(index);
    }

    @Override
    public UserIterator getUserIterator() {
        return new UserIteratorImpl(userList);
    }
}
