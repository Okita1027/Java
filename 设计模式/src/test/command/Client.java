package test.command;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 16:43 星期三
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        DetailCommand cmd = new DetailCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.addCommand(cmd);
        invoker.invoke();
    }
}
