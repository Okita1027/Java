package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author qzy
 * @time 2023/11/5 16:43 星期日
 * @title 136-只出现一次的数字
 */
public class T136_SingleNumber {
    public static void main(String[] args) {
        T136_SingleNumber fun = new T136_SingleNumber();
        fun.singleNum(new int[]{4, 2, 1, 2, 4});
    }
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for (Integer res : set) {
            return res;
        }
        return 0;
    }

    public int singleNum(int[] nums) {
        int x = 0;
        for (int num : nums) {  // 1. 遍历 nums 执行异或运算
            x ^= num;
            System.out.println(x);
        }
        return x;            // 2. 返回出现一次的数字 x
    }
}
