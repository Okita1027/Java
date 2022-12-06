package pattern.constructor.factory.factory_method;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Client
 * @Description 测试工厂方法
 * @Date 2022/6/18 16:28 星期六
 */
public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore(new AmericanCoffeeFactory());
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }
}
