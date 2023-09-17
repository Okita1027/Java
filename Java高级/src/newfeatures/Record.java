package newfeatures;

import java.util.Objects;

/**
 * @author qzy
 * @time 2023/9/16 22:38 星期六
 * Record类：为了实现一个简单的数据载体类，避免编写：构造函数，访问器，equals()，hashCode () ，toString ()等
 */
public class Record {
    /**
     * record 是一种全新的类型，它本质上是一个 final 类，同时所有的属性都是
     * final 修饰，它会自动编译出 public get 、hashcode 、equals、
     * toString、构造器等结构，减少了代码编写量。
     *
     * 具体来说：当你用 record 声明一个类时，该类将自动拥有以下功能：
     * • 获取成员变量的简单方法，比如例题中的 name() 和 partner() 。注意区别于我们平常 getter() 的写法。
     * • 一个 equals 方法的实现，执行比较时会比较该类的所有成员属性。
     * • 重写 hashCode() 方法。
     * • 一个可以打印该类所有成员属性的 toString() 方法。
     * • 只有一个构造方法。
     *
     * 此外：
     * • 还可以在 record 声明的类中定义静态字段、静态方法、构造器或实例方法。
     * • 不能在 record 声明的类中定义实例字段；类不能声明为 abstract；不能声明显式的父类等。
     *
     * 记录不适合哪些场景:
     * record 的设计目标是提供一种将数据建模为数据的好方法。
     * 它也不是JavaBeans 的直接替代品，因为 record 的方法不符合 JavaBeans 的 get 标准。
     * 另外 JavaBeans 通常是可变的，而记录是不可变的。尽管它们的用途有点像，但记录并不会以某种方式取代 JavaBean。
     */

    /**
     * 举例1：旧的写法
     */
    class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x() {
            return x;
        }

        int y() {
            return y;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point other = (Point) o;
            return other.x == x && other.y == y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    /**
     * 举例1：新的写法
     */
    record Pointer(int x, int y) {
    }

    record Dog(String name, Integer age) {
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("牧羊犬", 1);
        Dog dog2 = new Dog("田园犬", 2);
        Dog dog3 = new Dog("哈士奇", 3);
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);
    }

    public record Person(String name, Person partner) {
        //还可以声明静态的属性、静态的方法、构造器、实例方法
        public static String nation;

        public static String showNation() {
            return nation;
        }

        public Person(String name) {
            this(name, null);
        }

        public String getNameInUpperCase() {
            return name.toUpperCase();
        }
        // 不可以声明非静态的属性
        // private int id;//报错
    }
        /*
            不可以将 record 定义的类声明为 abstract 的
            abstract record Order(){

            }
            不可以给 record 定义的类声明显式的父类（非 Record 类）
            record Order() extends Thread{
            }
        */

}
