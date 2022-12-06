package algorithm.leetcode.easy;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName T383
 * @Description 赎金信
 * @Date 2022/6/19 8:49 星期日
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 示例 1：
 *  输入：ransomNote = "a", magazine = "b"
 *  输出：false
 *
 * 示例 2：
 *  输入：ransomNote = "aa", magazine = "ab"
 *  输出：false
 *
 * 示例 3：
 *  输入：ransomNote = "aa", magazine = "aab"
 *  输出：true
 *
 */
public class T383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] ch = new int[26];
        for (char c : magazine.toCharArray()) {
            ch[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            ch[c - 'a']--;
            if (ch[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
