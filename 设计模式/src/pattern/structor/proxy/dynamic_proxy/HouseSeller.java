package pattern.structor.proxy.dynamic_proxy;

/**
 * @Author qzy
 * @ClassName HouseSeller
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/20 12:57 星期二
 */
public class HouseSeller implements Sell {
    @Override
    public void sell(String name) {
        System.out.println("卖" + name + "房子");
    }
}
