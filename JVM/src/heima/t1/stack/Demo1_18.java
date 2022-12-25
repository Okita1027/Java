package heima.t1.stack;

/**
 * 局部变量的线程安全问题
 */
public class Demo1_18 {

    // 多个线程同时执行此方法
    static void m1() {
        //线程安全，因为 x 是局部变量
        int x = 0;
        for (int i = 0; i < 5000; i++) {
            x++;
        }
        System.out.println(x);
    }
}
