package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/27 11:18 星期五
 * @title LCR182-动态口令
 */
public class LCR182_DynamicPassword {
    public String dynamicPassword(String password, int target) {
        return password.substring(target) +
                password.substring(0, target);
    }
}
