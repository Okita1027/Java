package pattern.structor.decorator;

/**
 * @Author qzy
 * @ClassName Garish
 * @Description 抽象装饰（Decorator）角色：继承或实现抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * @Date 2022/12/20 18:47 星期二
 */
public abstract class Garish extends FastFood {

    private FastFood fastFood;

    public Garish(FastFood fastFood, double price, String description) {
        super(price, description);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
