package principle.里氏代换.before;

/**
 * @version v1.0
 * @ClassName: Square
 * @Description: 正方形类
 * @Author: 黑马程序员
 * 里氏代换原则：任何基类可以出现的地方，子类一定可以出现。通俗理解：子类可以扩展父类的功能，
 * 但不能改变父类原有的功能。换句话说，子类继承父类时，除添加新的方法完成新增功能外，尽量不要
 * 重写父类的方法。
 * 如果通过重写父类的方法来完成新的功能，这样写起来虽然简单，但是整个继承体系的可复用性会比较
 * 差，特别是运用多态比较频繁时，程序运行出错的概率会非常大。
 */
public class Square extends Rectangle {

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setLength(width);
        super.setWidth(width);
    }
}
