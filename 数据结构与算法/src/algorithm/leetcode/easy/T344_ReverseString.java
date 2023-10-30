package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/27 9:04 星期五
 * @title 344-反转字符串
 */
public class T344_ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < s.length / 2) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
