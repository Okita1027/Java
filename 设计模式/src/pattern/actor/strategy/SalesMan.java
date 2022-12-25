package pattern.actor.strategy;

/**
 * @Author qzy
 * @ClassName SalesMan
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/22 17:23 星期四
 */
public class SalesMan {
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public void showStrategy() {
        strategy.show();
    }
}
