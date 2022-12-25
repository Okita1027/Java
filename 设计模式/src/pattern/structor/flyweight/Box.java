package pattern.structor.flyweight;

/**
 * @Author qzy
 * @ClassName Box
 * @Description 抽象享元角色（Flyweight）：通常是一个接口或抽象类，在抽象享元类中声明了具体享元类公共的方法，
 * 这些方法可以向外界提供享元对象的内部数据（内部状态），同时也可以通过这些方法来设置外部数据（外部状态）。
 * @Date 2022/12/21 17:27 星期三
 */
public abstract class Box {
    public abstract String getShape();

    public void display(String color) {
        System.out.println("图形：" + getShape() + ";颜色：" + color);
    }
}
