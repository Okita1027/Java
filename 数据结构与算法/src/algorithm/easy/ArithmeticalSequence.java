package algorithm.easy;

/**
 * @Author qzy
 * @ClassName ArithmeticalSequence
 * @Description 等差数列
 * @Date 2023/1/25 22:04 星期三
 */
public class ArithmeticalSequence {
    public static void main(String[] args) {
        int even = 150, odd = 135, i, d, p = 0;
        int sum = 0;
        int[] num = new int[10];
        d = (even - odd) / 5;//先算出公差

        while (true) {
            for (i = 1; i <= 10; i++) {
                sum += p + d * i;
                num[i - 1] = d * i;
            }
            if (sum == even + odd) break;
            p++;
        }

        for (i = 0; i < 10; i++) {
            System.out.print(num[i] + "\t");
        }
    }
}
