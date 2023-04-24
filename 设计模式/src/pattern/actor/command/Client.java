package pattern.actor.command;

import javax.sound.midi.Receiver;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 命令模式
 * @Date 2022/12/22 17:25 星期四
 */
public class Client {
    public static void main(String[] args) {
        Order order = new Order();
        order.setTableNum(7);
        order.setFoodDic("potato", 1);
        order.setFoodDic("tomato", 2);

        OrderCommand orderCommand = new OrderCommand(new Chef(), order);

        Waitress waitress = new Waitress();
        waitress.setCommands(orderCommand);
        waitress.orderUp();
    }
}