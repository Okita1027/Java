package algorithm.easy;

import java.text.DecimalFormat;

/**
 * @Author qzy
 * @ClassName FibonacciSeries
 * @Description 斐波那契数列
 * @Date 2023/2/4 20:17 星期六
 */
public class FibonacciSeries {
    public static void main(String[] args) {
        //有⼀分数序列：2/1，3/2，5/3，8/5，13/8，21/13…求出这个数列的前20项之和。
        /*double[] son = new double[20];
        double[] mother = new double[20];
        son[0] = 2;
        son[1] = 3;
        mother[0] = 1;
        mother[1] = 2;
        double sum = son[0] / mother[0] + son[1] / mother[1];
        for (int i = 2; i < 20; i++) {
            son[i] = son[i - 1] + son[i - 2];
            mother[i] = mother[i - 1] + mother[i - 2];
            sum += son[i] / mother[i];
        }
        System.out.println("sum = " + sum);*/

        int son = 2, mother = 1, temp;
        double sum = 0;
        DecimalFormat df = new DecimalFormat("#0.0000");
        for (int i = 1; i <= 20; i++) {
            sum += (double) son / mother;
            temp = mother;
            mother = son;
            son += temp;
            System.out.println("第 " + i + " 次相加，和是 " + df.format(sum));
        }
    }
}
