package algorithm.easy;

/**
 * @Author qzy
 * @ClassName CompleteNum
 * @Description 完全数：恰好等于它的因子之和
 * 例如：6 = 1 + 2 + 3
 * @Date 2023/1/20 21:26 星期五
 */
public class PerfectNum {
    public static void main(String[] args) {
        //找出1000以内的完数
        for (int num = 1; num < 1000; num++) {
            int cache = num;
            //1一定能除尽，故从2开始
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    cache -= i;
                }
            }
            //由于没有除1，故此处不是0而是1
            if (cache == 1) {
                System.out.println(num + "是完全数！");
            }
        }
    }
}
