package pattern.actor.responsibility;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/23 16:11 星期五
 */
public class Client {
    public static void main(String[] args) {
        Request request = new Request("qzy", 5, "我要请假!");
        LeaderHandler handler = new LeaderHandler(new ManagerHandler(new CEOHandler(null)));
        handler.submit(request);
    }
}
