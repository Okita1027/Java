package pattern.structor.proxy.static_proxy;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName TrainStation
 * @Description 火车站卖票
 * @Date 2022/6/22 22:02 星期三
 */
public class TrainStation implements Sell {

    @Override
    public void sellTicket() {
        System.out.println("售卖火车票……");
    }
}
