package pattern.constructor.factory.abstract_factory;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName ItalyDessertFactory
 * @Description 意大利风味咖啡、甜点工厂
 * @Date 2022/6/18 17:10 星期六
 */
public class ItalyFactory implements DessertFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        //提拉米苏属于意大利风味
        return new Tiramisu();
    }
}
