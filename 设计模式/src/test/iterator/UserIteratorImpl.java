package test.iterator;

import java.util.List;

/**
 * @Author qzy
 * @ClassName UserIteratorImpl
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 19:48 星期四
 */
public class UserIteratorImpl implements UserIterator {
    private int index;
    private final List<User> userList;

    public UserIteratorImpl(List<User> userList) {
        index = 0;
        this.userList = userList;
    }

    @Override
    public boolean hasNext() {
        return index < userList.size();
    }

    @Override
    public User next() {
        return userList.get(index++);
    }
}
