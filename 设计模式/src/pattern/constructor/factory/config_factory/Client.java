package pattern.constructor.factory.config_factory;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Client
 * @Description config_Factory测试类
 * @Date 2022/6/18 18:29 星期六
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());

        System.out.println("=============");
        Coffee latte = CoffeeFactory.createCoffee("latte");
        System.out.println(latte.getName());
    }
}
