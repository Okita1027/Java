package algorithm.divide_conquer;

/**
 * @author qzy
 * @time 2023/11/19 14:21 星期日
 * @title 快速幂
 */
public class QuickPow {
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(quickPow(x, n));
    }

    public static double quickPow(int x, long n) {
        long pow = n;
        if (pow < 0) {
            pow = -pow;
        }
        double result = quickPowPositive(x, pow);
        return n < 0 ? 1 / result : result;
    }
    public static int quickPowPositive(int x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        int res = quickPowPositive(x, n / 2) * quickPowPositive(x, n / 2);


        if (n % 2 == 0) {
            return res;
        } else {
            return x * res;
        }
    }

    public boolean isJi(int num) {
        if ((num & 1) == 0) {
            System.out.println(num + "是偶数");
            return true;
        } else {
            System.out.println(num + "是奇数");
            return false;
        }
    }
}
