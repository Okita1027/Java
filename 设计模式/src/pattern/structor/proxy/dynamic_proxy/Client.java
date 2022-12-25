package pattern.structor.proxy.dynamic_proxy;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 测试类
 * @Date 2022/12/20 13:06 星期二
 */
public class Client {
    public static void main(String[] args) {
        new ProxyFactory().getProxy().sell("！房子！");
        /*Sell proxy = (Sell) ProxyFactory.getProxy(new HouseSeller());
        proxy.sell("‘别墅’");*/
    }
}
