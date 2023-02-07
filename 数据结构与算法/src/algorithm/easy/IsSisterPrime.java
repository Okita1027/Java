package algorithm.easy;

/**
 * @Author qzy
 * @ClassName 姐妹素数
 * @Description 判断相邻的2个奇数是否都是素数
 * @Date 2023/1/20 20:54 星期五
 */
public class IsSisterPrime {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i < 1000; i += 2) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.print(i + "/" + (i + 2) + "\t");
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
