package algorithm.easy;

/**
 * @Author qzy
 * @ClassName NineMulNine
 * @Description 9X9乘法表
 * @Date 2023/2/5 21:32 星期日
 */
public class NineMulNine {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "×" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
