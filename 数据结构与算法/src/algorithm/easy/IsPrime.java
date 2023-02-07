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
        for (int i = 2; i < 50; i++) {
            if (isPrime(i)) {
                System.out.print(i + "\t");
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
