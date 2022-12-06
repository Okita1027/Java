package pattern.constructor.factory.factory_method;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName AmericanCoffeeFactory
 * @Description 制造美式咖啡
 * @Date 2022/6/18 16:16 星期六
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
