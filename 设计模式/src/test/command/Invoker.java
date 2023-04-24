package test.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName Invoker
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 16:40 星期三
 */
public class Invoker {
    private List<AbstractCommand> commandList;

    public Invoker() {
        commandList = new ArrayList<>();
    }

    public void addCommand(AbstractCommand cmd) {
        System.out.println("Invoker得到了一条命令！");
        commandList.add(cmd);
    }

    public void invoke() {
        System.out.println("Invoker呼叫执行命令……");
        for (AbstractCommand cmd : commandList) {
            cmd.executeCommand();
        }
    }
}
