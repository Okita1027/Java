package algorithm.recursion;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/9/14 22:27 星期四
 * 斐波那契数列（递归）
 */
public class Fibonacci {

    /**
     * 改进部分
     */
    private static int[] cache;
    public static int fun(int n) {
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return fibonacci(n);
    }

    private static int fibonacci(int n) {
        /*if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }*/

        /**
         * 改进部分
         */
        if (cache[n] != -1) {
            return cache[n];
        }

        int x = fibonacci(n - 1);
        int y = fibonacci(n - 2);
        cache[n] = x + y;
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fun(8));
    }
}
