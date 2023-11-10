package algorithm.leetcode.medium;

import java.util.*;

/**
 * @author qzy
 * @time 2023/11/5 14:44 星期日
 * @title 3-无重复字符的最长子串
 */
public class T3_NonRepeatingLongestSubString {
    public static void main(String[] args) {
        String s = "dvdh";
        T3_NonRepeatingLongestSubString fun = new T3_NonRepeatingLongestSubString();
        System.out.println(fun.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[s.length()];
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 队列中存在该元素，说明重复了
            if (queue.contains(ch)) {
                // 要删除当前字母前的所有元素
                while (queue.poll() != ch) {
                    ;
                }
                // 开始下一次计数
                j++;
            }
            // 加入当前字符到队列中并增长计数器
            queue.offer(s.charAt(i));
            count[j] = queue.size();
        }

        // 返回最大值
        return Arrays.stream(count).max().getAsInt();
    }

}
