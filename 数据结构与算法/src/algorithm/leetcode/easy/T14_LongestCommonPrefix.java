package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qzy
 * @time 2023/10/29 10:07 星期日
 * @title 14-最长公共前缀
 */
public class T14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        T14_LongestCommonPrefix fun = new T14_LongestCommonPrefix();
        System.out.println(fun.longestCommonPrefix(strs));
        strs = new String[]{"ab", "a"};
        System.out.println(fun.longestCommonPrefix(strs));
        strs = new String[]{"flower", "flower", "flower", "flower", "flower", "flower"};
        System.out.println(fun.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        // 如果数组只有一个字符串，则该字符串本身就是最长公共前缀
        if (strs.length == 1) {
            return strs[0];
        }

        int longestCommonPrefix = 0;
        char ch;
        int i = 0;

        // 遍历第一个字符串的每个字符
        while (i < strs[0].length()) {
            ch = strs[0].charAt(i);

            // 遍历其他字符串，比较相同位置的字符是否相等
            for (int j = 1; j < strs.length && i < strs[j].length(); j++) {
                if (ch == strs[j].charAt(i)) {
                    // 如果当前字符相等，并且已经遍历到最后一个字符串，则最长公共前缀长度加1
                    if (j == strs.length - 1) {
                        longestCommonPrefix++;
                    }
                } else {
                    // 如果当前字符不相等，则返回最长公共前缀
                    return strs[0].substring(0, longestCommonPrefix);
                }
            }
            // 继续遍历下一个字符
            i++;
        }
        return strs[0].substring(0, longestCommonPrefix);
    }

}
