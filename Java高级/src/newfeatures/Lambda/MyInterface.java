package newfeatures.Lambda;

/**
 * @time 2022/5/8 14:11 星期日
 * 函数式接口，即只能有一个抽象方法
 * Java内置四大核心函数式接口：
 * Consumer<T>消费型接口：void accept(T t)
 * Supplier<T>供给型接口：T get()
 * Function<T,R>函数型接口：对类型为T的对象应用操作：R apply(T t)
 * Predicate<T>断定型接口：确定类型为T的对象是否满足某约束：boolean test(T t)
 */

//声明为函数式接口
@FunctionalInterface
public interface MyInterface {
    void method1();

    default void method2() {
        method3();
        System.out.println("这是接口的默认方法2！");
        System.out.println("方法2调用了私有的方法3");
    }

    private void method3() {
        System.out.println("这是接口的私有方法3！");
    }

    static void method4() {
        System.out.println("方法2调用了私有的方法3");
        System.out.println("这是接口的静态方法4！");
    }
}
