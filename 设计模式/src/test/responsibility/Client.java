package test.responsibility;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 8:54 星期四
 */
public class Client {
    public static void main(String[] args) {
        int dayNum = 2;
        Leader leader = new Leader(new Group(new Manager(null)));
        leader.handle(dayNum);
    }
}
