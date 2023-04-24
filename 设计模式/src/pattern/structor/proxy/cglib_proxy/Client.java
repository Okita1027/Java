package pattern.structor.proxy.cglib_proxy;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/20 14:42 星期二
 */
public class Client {
    public static void main(String[] args) {
        new ProxyFactory().getProxy().helpFindJob();
        JobHelper proxy = (JobHelper) new ProxyFactory2().getProxy(new JobHelper());
        proxy.helpFindJob();

    }
}
