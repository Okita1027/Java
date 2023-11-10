package algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * @author qzy
 * @time 2023/10/29 11:34 星期日
 * @title 387-字符串中的第一个唯一字符
 */
public class T387_FirstUniqueChar {
    public static void main(String[] args) {
        String str = "loveleetcode";
        str = "leetcode";
        System.out.println(new T387_FirstUniqueChar().firstUniqueChar(str));
    }
    public int firstUniqueChar(String str) {
        HashMap<Character, Boolean> map = new HashMap<>();
        // 遍历字符串
        for (int i = 0; i < str.length(); i++) {
            // 若不包含当前字符，则以字符为键，将值置为true; 否则false
            map.put(str.charAt(i), !map.containsKey(str.charAt(i)));
        }
        // 遍历哈希表，找到第一个值为true的
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
