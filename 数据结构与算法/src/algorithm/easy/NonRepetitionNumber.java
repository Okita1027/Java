package algorithm.easy;

/**
 * @Author qzy
 * @ClassName T4
 * @Description 1234组成不重复三位数
 * @Date 2023/1/9 16:52 星期一
 */
public class NonRepetitionNumber {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if (i != j && i != k && j != k) {
                        System.out.printf("%-4d", i * 100 + j * 10 + k);
                        /*System.out.print(i);
                        System.out.print(j);
                        System.out.print(k);
                        System.out.print(" ");*/
                    }
                }
            }
            System.out.println();
        }
    }
}
