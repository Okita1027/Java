package test.iterator;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 19:55 星期四
 */
public class Client {
    public static void main(String[] args) {
        User user1 = new User("a", "aa");
        User user2 = new User("b", "bb");
        User user3 = new User("c", "cc");
        UserAggregateImpl userAggregate = new UserAggregateImpl();
        userAggregate.addUser(user1);
        userAggregate.addUser(user2);
        userAggregate.addUser(user3);
        UserIterator userIterator = userAggregate.getUserIterator();
        while (userIterator.hasNext()) {
            User next = userIterator.next();
            System.out.println("next = " + next);
        }
    }
}
