package test.command;

/**
 * @Author qzy
 * @ClassName DetailCommand
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 16:38 星期三
 */
public class DetailCommand implements AbstractCommand {
    private Receiver receiver;

    public DetailCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void executeCommand() {
        System.out.println("命令准备交给receiver执行...");
        receiver.fun();
    }
}
