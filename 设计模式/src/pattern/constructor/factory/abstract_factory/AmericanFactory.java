package pattern.constructor.factory.abstract_factory;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName AmericanDessertFactory
 * @Description 美式风味咖啡、甜点工厂
 * @Date 2022/6/18 17:02 星期六
 */
public class AmericanFactory implements DessertFactory {

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        //抹茶慕斯是美式风味的
        return new MatchaMousse();
    }
}
