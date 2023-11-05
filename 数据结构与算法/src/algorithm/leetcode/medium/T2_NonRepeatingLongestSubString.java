package algorithm.leetcode.medium;

import java.util.*;

/**
 * @author qzy
 * @time 2023/11/5 14:44 星期日
 * @title 2-无重复字符的最长子串
 */
public class T2_NonRepeatingLongestSubString {
    public static void main(String[] args) {
        String s = "dvdh";
        T2_NonRepeatingLongestSubString fun = new T2_NonRepeatingLongestSubString();
        System.out.println(fun.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[s.length()];
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (queue.contains(ch)) {
                while (queue.poll() != ch) {
                    ;
                }
                j++;
            }
            queue.offer(s.charAt(i));
            count[j] = queue.size();
        }

        return Arrays.stream(count).max().getAsInt();
    }

}
