package test.iterator;

/**
 * @Author qzy
 * @ClassName User
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 19:42 星期四
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
