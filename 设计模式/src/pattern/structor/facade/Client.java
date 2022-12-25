package pattern.structor.facade;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 外观模式是符合“迪米特法则”的经典案例
 *              Client不能直接访问Light/TV，却能通过AI间接使用它们。
 * @Date 2022/12/21 15:05 星期三
 */
public class Client {
    public static void main(String[] args) {
        XiaoAiClassmate AI = new XiaoAiClassmate();
        AI.voiceControl("！开！");
    }
}
