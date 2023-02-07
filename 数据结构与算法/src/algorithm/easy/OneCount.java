package algorithm.easy;

/**
 * @Author qzy
 * @ClassName 力扣233-困难
 * @Description 统计1的个数：1-10有2个1，1-20有10个1
 * @Date 2023/2/4 21:19 星期六
 */
public class OneCount {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int num = 123, saveNum = 1, countNum = 0, lastNum = 0;
        int copyNum = num;
        while (num != 0) {
            lastNum = num % 10;
            num /= 10;
            if (lastNum == 0) {
                // 如果是0那么正好是少了一次所以num不加1了
                countNum += num * saveNum;
            } else if (lastNum == 1) {
                // 如果是1说明当前数内少了一次所以num不加1，而且当前1所在位置
                // 有1的个数，就是去除当前1最高位，剩下位数，的个数。
                countNum += num * saveNum + copyNum % saveNum + 1;
            } else {
                // 如果非1非0.直接用公式计算
                // abcd...=(abc+1)*1+(ab+1)*10+(a+1)*100+(1)*1000...
                countNum += (num + 1) * saveNum;
            }
            saveNum *= 10;
        }
        System.out.println("1的个数：" + countNum);
        System.out.println("计算耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
