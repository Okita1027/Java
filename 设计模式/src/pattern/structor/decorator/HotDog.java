package pattern.structor.decorator;

/**
 * @Author qzy
 * @ClassName Egg
 * @Description 具体装饰（ConcreteDecorator）角色 ：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 * @Date 2022/12/20 18:49 星期二
 */
public class HotDog extends Garish{

    public HotDog(FastFood fastFood) {
        super(fastFood, 2, "（烤）热狗");
    }

    @Override
    public double cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDescription() {
        return getFastFood().getDescription() + "+" + super.getDescription();
    }
}
