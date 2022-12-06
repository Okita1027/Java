package pattern.structor.proxy.static_proxy;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Client
 * @Description 测试类
 * @Date 2022/6/22 22:05 星期三
 */
public class Client {
    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sellTicket();
    }
}
