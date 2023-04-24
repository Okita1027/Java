package pattern.structor.proxy.exercise;

import pattern.structor.proxy.static_proxy.Sell;
import pattern.structor.proxy.static_proxy.TrainStation;

/**
 * @Author qzy
 * @ClassName Test
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/18 10:40 星期二
 */
public class Test {
    public static void main(String[] args) {
        Job proxy = (Job) JdkProxy.getProxy(new BOSSJob());
        proxy.findJob();
        proxy.fun("abc");

        Sell sellProxy = (Sell) ProxyFactory.getProxy(new TrainStation());
        sellProxy.sellTicket();
    }
}
