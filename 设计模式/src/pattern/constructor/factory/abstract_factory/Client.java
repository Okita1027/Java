package pattern.constructor.factory.abstract_factory;


/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Client
 * @Description 抽象工厂测试类
 * @Date 2022/6/18 17:19 星期六
 */
public class Client {
    public static void main(String[] args) {
        //咖啡店：美式咖啡、甜点
        CoffeeStore coffeeStore = new CoffeeStore(new AmericanFactory());
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
        Dessert dessert = coffeeStore.orderDessert();
        System.out.println(dessert.getName());
        System.out.println("-------");
        //咖啡店：意式咖啡、甜点
        CoffeeStore italyStore = new CoffeeStore(new ItalyFactory());
        System.out.println(italyStore.orderCoffee().getName());
        System.out.println(italyStore.orderDessert().getName());
    }
}
