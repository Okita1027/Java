package algorithm.easy;

/**
 * @Author qzy
 * @ClassName PerfectSquare
 * @Description 完全平方数：
 * ⼀个整数，它加上100后是⼀个完全平⽅数，再加上168⼜是⼀个完全平⽅数，请问该数是多少？
 * @Date 2023/2/3 22:12 星期五
 */
public class PerfectSquare {
    public static void main(String[] args) {
        for (int num = 1; num < 10000; num++) {
            int sqrt1 = (int) Math.sqrt(num + 100);
            int sqrt2 = (int) Math.sqrt(num + 100 + 168);
            if ((sqrt1 * sqrt1 == num + 100) && (sqrt2 * sqrt2 == num + 100 + 168)) {
                System.out.print(num + "\t");
            }
        }
    }

}
