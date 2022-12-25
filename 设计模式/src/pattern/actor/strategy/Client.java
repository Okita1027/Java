package pattern.actor.strategy;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/22 17:03 星期四
 */
public class Client {
    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.showStrategy();
    }
}
