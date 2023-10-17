package algorithm.leetcode.easy;

/**
 * @Date 2022/6/15 19:42 星期三
 * 回文数
 */
public class T9_PalindromicNumber {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int mid = s.length() / 2;
        int right = s.length() - 1;
        // 让两个指针分别指向字符串的首尾
        for (int i = 0; i < mid; i++) {
            // 对指针所在元素进行比对，若不同，则不是回文数
            if (s.charAt(i) != s.charAt(right)) {
                return false;
            }
            //若相同则左指针向右移，右指针向左移
            right--;
        }
        return true;
    }
}
