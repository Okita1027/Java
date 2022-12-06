package pattern.constructor.factory.factory_method;

/**
 * @Date 2022/6/18 15:59 星期六
 * 拿铁咖啡工厂
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
