package algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qzy
 * @time 2023/11/5 10:24 星期日
 * @title 202-快乐数
 */
public class T202_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>(); // 用于记录中间计算结果的集合，防止陷入循环
        while (n != 1 && !record.contains(n)) { // 当n不等于1且record中不包含n时继续循环
            record.add(n); // 将当前n添加至record集合中
            n = getNextNumber(n); // 获取下一个数，更新n的值
        }
        return n == 1; // 返回n是否为1，即判断该数是否是快乐数
    }

    private int getNextNumber(int n) {
        int res = 0; // 用于存储下一个数的变量
        while (n > 0) { // 当n大于0时继续循环
            int temp = n % 10; // 取n的个位数
            res += temp * temp; // 将个位数的平方累加到res中
            n = n / 10; // 更新n，去掉个位数
        }
        return res; // 返回下一个数的值
    }

}
