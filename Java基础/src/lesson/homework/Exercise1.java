package lesson.homework;

/**
 * @author qzy
 * @time 2023/10/16 15:44 星期一
 * @title 1)	定义抽象类BaseComputer，包含可被继承的属性brand（品牌），size（尺寸）以及公有方法getBrand和getSize获得该电脑的品牌和尺寸信息。
 *        2)	定义MacBook类继承BaseComputer，提供构造方法对brand和size赋值。
 *        3)	定义接口Programmer，声明coding方法，其入参为BaseComputer类型的对象
 *        4)	JavaProgrammer类实现了Programmer接口，增加name属性并通过构造方法或setter方法对其赋值，然后对父类的coding方法重写，就输出如“Java程序员***正在用***电脑写代码，电脑尺寸为13寸”这样的信息
 *        5)	测试主程序，利用多态的特性创建BaseComputer的实例computer，创建Programmer的实例programmer，并调用programmer的coding方法。
 */

abstract class BaseComputer {
    protected String brand;
    protected int size;

    public BaseComputer(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }
}


class MacBook extends BaseComputer {
    public MacBook(String brand, int size) {
        super(brand, size);
    }
}


interface Programmer {
    void coding(BaseComputer computer);
}


class JavaProgrammer implements Programmer {
    private String name;

    public JavaProgrammer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void coding(BaseComputer computer) {
        System.out.println("Java程序员" + name + "正在用" + computer.getBrand() + "电脑写代码，电脑尺寸为" + computer.getSize() + "寸");
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        BaseComputer computer = new MacBook("Apple", 13);
        Programmer programmer = new JavaProgrammer("张三");
        programmer.coding(computer);
    }
}
