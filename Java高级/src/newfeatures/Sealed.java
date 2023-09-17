package newfeatures;

/**
 * @author qzy
 * @time 2023/9/16 22:57 星期六
 * 背景：
 *  在 Java 中如果想让一个类不能被继承和修改，这时我们应该使用 final 关键字对类进行修饰。
 *  不过这种要么可以继承，要么不能继承的机制不够灵活，
 *  有些时候我们可能想让某个类可以被某些类型继承，但是又不能随意继承，是做不到的。
 *  Java 15 尝试解决这个问题，引入了 sealed 类，被 sealed 修饰的类可以指定子类。这样这个类就只能被指定的类继承。
 *  通过密封的类和接口来限制超类的使用，密封的类和接口限制其它可能继承或实现它们的其它类或接口。
 * 具体使用：
 * • 使用修饰符 sealed，可以将一个类声明为密封类。密封的类使用保留关键字permits 列出可以直接扩展（即 extends）它的类。
 * • sealed 修饰的类的机制具有传递性，它的子类必须使用指定的关键字进行修饰，且只能是 final、sealed、non-sealed 三者之一。
 * JDK16 二次预览特性
 * JDK17 中转正特性
 */
public class Sealed {
    /**
     * 举例
     */
    public abstract sealed class Shape permits Circle, Rectangle, Square {}
    public final class Circle extends Shape {} //final 表示 Circle 不能再被继承了
    public sealed class Rectangle extends Shape permits TransparentRectangle, FilledRectangle {}
    public final class TransparentRectangle extends Rectangle {}
    public final class FilledRectangle extends Rectangle {}
    public non-sealed class Square extends Shape {} //non-sealed 表示可以允许任何类继承
}
