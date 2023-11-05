package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/11/2 20:18 星期四
 * @title 258-各位相加
 */
public class T258_AddDigits {
    public int addDigits(int num)
    {
        // 1、能够被9整除的整数，各位上的数字加起来也必然能被9整除，所以，连续累加起来，最终必然就是9。
        if(0 < num && 0 == num % 9) {   // 0 是特殊情况，单独处理
            return 9;
        }
        //2、不能被9整除的整数，各位上的数字加起来，结果对9取模，和初始数对9取摸，是一样的，所以，连续累加起来，最终必然就是初始数对9取摸。
        return num % 9;
    }
}
