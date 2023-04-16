package algorithm.easy;

/**
 * @Author qzy
 * @ClassName IsPrime
 * @Description 判断50以内的素数
 * @Date 2023/1/23 22:33 星期一
 */
public class IsPrime {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i < 200; i += 2) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + "\t");
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
