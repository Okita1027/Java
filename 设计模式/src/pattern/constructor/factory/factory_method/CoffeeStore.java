package pattern.constructor.factory.factory_method;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName CoffeeStore
 * @Description 咖啡店
 * @Date 2022/6/18 16:25 星期六
 */
public class CoffeeStore {
    private CoffeeFactory factory;

    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }

}
