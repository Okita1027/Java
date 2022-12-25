package pattern.actor.strategy;

/**
 * @Author qzy
 * @ClassName StrategyA
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/22 17:22 星期四
 */
public class StrategyA implements Strategy{
    @Override
    public void show() {
        System.out.println("策略1：50包邮解君愁");
    }
}
