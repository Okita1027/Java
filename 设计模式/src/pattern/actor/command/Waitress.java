package pattern.actor.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName Waitress
 * @Description 服务员-调用者/请求者（Invoker）角色： 要求命令对象执行请求，通常会持有命令对象，可以持有很
 * 多的命令对象。这个是客户端真正触发命令并要求命令执行相应操作的地方，也就是说相当于使用
 * 命令对象的入口。
 * @Date 2022/12/22 19:17 星期四
 */
public class Waitress {
    private List<Command> commands;

    public Waitress() {
        commands = new ArrayList<>();
    }

    public void setCommands(Command cmd) {
        commands.add(cmd);
    }

    public void orderUp() {
        System.out.println("服务员：大厨，新订单来了！");
        for (Command cmd : commands) {
            if (cmd != null) {
                cmd.execute();
            }
        }
    }
}
