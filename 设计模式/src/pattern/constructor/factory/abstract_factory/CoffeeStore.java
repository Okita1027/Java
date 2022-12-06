package pattern.constructor.factory.abstract_factory;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName CoffeeStore
 * @Description 咖啡、甜品店
 * @Date 2022/6/18 17:15 星期六
 */
public class CoffeeStore {
    private AmericanFactory americanDessertFactory;
    private ItalyFactory italyDessertFactory;

    public CoffeeStore(AmericanFactory americanDessertFactory) {
        this.americanDessertFactory = americanDessertFactory;
    }

    public CoffeeStore(ItalyFactory italyDessertFactory) {
        this.italyDessertFactory = italyDessertFactory;
    }

    public Coffee orderCoffee() {
        if (americanDessertFactory != null) {
            return americanDessertFactory.createCoffee();
        }
        return italyDessertFactory.createCoffee();
    }

    public Dessert orderDessert() {
        if (americanDessertFactory != null) {
            return americanDessertFactory.createDessert();
        }
        return italyDessertFactory.createDessert();
    }
}
