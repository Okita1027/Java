package pattern.actor.status;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/23 18:23 星期五
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new OpeningState());
        context.open();
    }
}
