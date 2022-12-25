package pattern.actor.command;

import java.util.Set;

/**
 * @Author qzy
 * @ClassName OrderCommand
 * @Description 具体命令（Concrete Command）角色：具体的命令，实现命令接口；通常会持有接收者，并调
 * 用接收者的功能来完成命令要执行的操作。
 * @Date 2022/12/22 18:03 星期四
 */
public class OrderCommand implements Command{
    //持有接受者对象
    private Chef receiver;
    //接收者处理的东西
    private Order order;

    public OrderCommand(Chef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getTableNum() + "号桌的订单：");
        Set<String> keySet = order.getFoodDic().keySet();
        for (String foodName : keySet) {
            receiver.cook(foodName, order.getFoodDic().get(foodName));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("大厨：" + order.getTableNum() + "桌的饭菜做好了！");
    }
}
