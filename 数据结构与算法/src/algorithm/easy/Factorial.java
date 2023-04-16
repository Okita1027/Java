package algorithm.easy;

/**
 * @Author qzy
 * @ClassName T2
 * @Description 阶乘
 * @Date 2023/1/9 16:14 星期一
 */
public class Factorial {
    public static void main(String[] args) {
        /*//求5！
        int x = 5;
        int sum = 1;
        for (int i = 2; i <= x; i++) {
            sum *= i;
        }
        System.out.println(sum);*/

        //求1！+2！...10！
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            int temp = 1;
            for (int j = 2; j <= i; j++) {
                temp *= j;
            }
            sum += temp;
        }
        System.out.println(sum);
    }
}
