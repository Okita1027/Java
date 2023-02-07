package algorithm.easy;

import java.util.Random;

/**
 * @Author qzy
 * @ClassName APlusAAPlusAAA
 * @Description 求s=a+aa+aaa+……例如：1+11+111=123
 * @Date 2023/1/25 21:39 星期三
 */
public class APlusAAPlusAAA {
    public static void main(String[] args) {
        //求s=a+aa+aaa+……例如：1+11+111=123
        int a = 2;//a：2
        int n = 3;//算式：2+22+222 =》 246
        int temp = a;//记录a的初始值
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a;
            a *= 10;
            a += temp;
        }
        System.out.println("sum = " + sum);
        /*
        int a = new Random().nextInt(5) + 1;
        int count = new Random().nextInt(10) + 1;
        System.out.println(a);
        System.out.println(count);
        int num = 0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                sum = num = a;
            } else {
                num = num * 10 + a;
                sum += num;
            }
        }
        System.out.println("sum = " + sum);*/
    }

}
