package test.oop;

/**
 * @Author qzy
 * @ClassName RubbishFile
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/2/7 21:56 星期二
 */
public class RubbishFile {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.a);
        B b = new B();
        System.out.println(b.a);
        a.fun();

    }
}
class A {
    int a=1;

    void fun() {
        System.out.println("AAA");
    }
}
class B extends A {
    int a = 2;
    @Override
    void fun() {
        System.out.println("BBB");
    }
}
