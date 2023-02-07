package class_.枚举类;

/**
 * @author 秦智耘
 * @date 2021/8/7 - 2021年8月7日09:16:36
 */
public class Enum {
    public static void main(String[] args) {
        //获得变量名的位置值. 变量声明的位置一旦改变,其值也将改变
        System.out.println(Season.SPRING.ordinal());
        //调用专属方法和通用方法
        Season.SPRING.printHot();
        Season.AUTUMN.printHot();
        //name 和 toString方法作用都是输出变量名的字符串形式
        System.out.println(Season.SUMMER.name());
        System.out.println(Season.SUMMER.toString());
        //compareTo用于比较两个枚举值的值，其内部实现是根据每个枚举的ordinal值大小进行比较的
        System.out.println(Season.AUTUMN.compareTo(Season.WINTER));
        //getDeclaringClass方法用于获取此枚举常量的枚举类型相对应的 Class 对象
        System.out.println(Season.WINTER.getDeclaringClass());
    }
}

/*
 * 在JDK1.5之前，没有enum类，取而代之的方法是写一个普通类，里面的变量都用 final 、 static 修饰
 * enum类的原理是编译器帮我们把 下面的 SPRING, SUMMER, AUTUMN, WINTER;一个个得加上了final 、 static 修饰符
 * enum中的变量值 从0开始，ordinal方法用于查看变量名对应的值
 * enum是个普通类，但他继承自ENUM类，由于JAVA单继承的特点，enum想用其他功能就只能实现接口的方式。
 * */
enum Season implements HotSummer {
    SPRING {
        //可以给变量单独实现接口中的方法
        @Override
        public void printHot() {
            System.out.println("一年四季中春天很暖和！");
        }
    }, SUMMER, AUTUMN, WINTER {
        @Override
        public void printHot() {
            System.out.println("一年四季中冬天很冷！");
        }
    };

    @Override
    public void printHot() {
        System.out.println("一年四季中夏天很热！");
    }
}

interface HotSummer {
    void printHot();
}