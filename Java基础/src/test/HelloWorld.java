package test;

/**
 * @Author qzy
 * @ClassName HelloWorld
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/2 12:47 星期一
 */
public class HelloWorld {
    public static void main(String []args) {
        A a = new B();
        a.fun();
        System.out.println("k3 = " + a.k);
    }
}
class A {
    int k = 10;
    void fun () {
        System.out.println("k1 = " + k);
    }
}
class B extends A {
    int k = 20;
    void fun() {
        System.out.println("(before)k2 = " + k);
        k = 15;
        System.out.println("(after)k2 = " + k);
    }
}