package reflection.Proxy;

/**
 * @time 2022/5/7 17:46 星期六
 * 静态代理
 * 代理类和被代理类在编译期间，就确定下来了
 */
interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作……");
        factory.produceCloth();
        System.out.println("代理工厂做一些收尾工作……");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生成一批衣服！");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //被代理类对象
        NikeClothFactory nike = new NikeClothFactory();
        //代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
