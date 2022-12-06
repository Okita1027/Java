package pattern.structor.proxy.static_proxy;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName ProxyPoint
 * @Description 代理点：用于售卖火车票
 * @Date 2022/6/22 22:03 星期三
 */
public class ProxyPoint implements Sell{

    TrainStation trainStation = new TrainStation();

    @Override
    public void sellTicket() {
        System.out.println("代理点收取服务费");
        trainStation.sellTicket();
    }
}
