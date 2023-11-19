package algorithm.dynamic_programming;

/**
 * @author qzy
 * @time 2023/11/17 14:52 星期五
 * @title 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        int num = 13;
        System.out.println("new Fibonacci().fib(5) = " + new Fibonacci().fib(num));
    }

    public int fib(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int a, b, c;
        a = 0;
        b = 1;
        for (int i = 2; i <= num; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
