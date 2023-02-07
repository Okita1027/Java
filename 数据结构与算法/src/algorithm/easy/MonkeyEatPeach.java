package algorithm.easy;

/**
 * @Author qzy
 * @ClassName MonkeyEatPeach
 * @Description 猴⼦第⼀天摘下若⼲个桃⼦，当即吃了⼀半，还不瘾，⼜多吃了⼀个 第⼆天早上⼜将剩
 * 下的桃⼦吃掉⼀半，⼜多吃了⼀个。以后每天早上都吃了前⼀天剩下 的⼀半零⼀个。到第10天
 * 早上想再吃时，见只剩下⼀个桃⼦了。求第⼀天共摘了多少。
 * @Date 2023/2/3 22:48 星期五
 */
public class MonkeyEatPeach {
    public static void main(String[] args) {
        //循环
        int lastDayNum = 1;
        for (int i = 2; i <= 10; i++) {
            lastDayNum = (lastDayNum + 1) * 2;
        }
        System.out.println("猴子第一天摘了 " + lastDayNum + " 个桃子");

        //递归
        System.out.println("第一天摘的桃子个数为：" + peachNum(1));
    }
    private static int peachNum(int day) {
        //第10天只剩下了一个桃子
        if (day == 10) {
            return 1;
        }
        //前一天剩下的桃子个数是 （今天个数+1）的两倍
        return (peachNum(day + 1) + 1) * 2;
    }

}
