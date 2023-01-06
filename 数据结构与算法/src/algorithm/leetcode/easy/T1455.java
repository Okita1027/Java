package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName T1455
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/6 17:45 星期五
 */
public class T1455 {
    public static void main(String[] args) {
        System.out.println(new T1455().isPrefixOfWord("I like eating hamburger", "eat"));
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strArr = sentence.split(" ");
        int index = -1;
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length() && j < searchWord.length(); j++) {
                if (strArr[i].charAt(j) != searchWord.charAt(j)) {
                    break;
                }
                index = i + 1;
            }
            if (index != -1) {
                break;
            }
        }

        return index;
    }
}
