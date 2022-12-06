package pattern.constructor.factory.abstract_factory;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName DessertFactory
 * @Description 咖啡、甜点工厂
 * @Date 2022/6/18 17:04 星期六
 */
public interface DessertFactory {
    Coffee createCoffee();
    Dessert createDessert();
}
