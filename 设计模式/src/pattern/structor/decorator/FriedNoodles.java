package pattern.structor.decorator;

/**
 * @Author qzy
 * @ClassName FriedRice
 * @Description 炒饭-具体构件（Concrete Component）角色 ：实现抽象构件，通过装饰角色为其添加一些职责。
 * @Date 2022/12/20 18:38 星期二
 */
public class FriedNoodles extends FastFood {
    public FriedNoodles() {
        super(12, "（黄铜）炒面");
    }

    @Override
    public double cost() {
        return getPrice();
    }
}
