package algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * @author qzy
 * @time 2023/11/2 20:21 星期四
 * @title 242-有效的字母异位词
 */
public class T242_ValidAlphabeticWords {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
