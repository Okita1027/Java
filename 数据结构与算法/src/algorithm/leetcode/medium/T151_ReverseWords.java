package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/27 10:27 星期五
 * @title 151-反转字符串中单词
 */
public class T151_ReverseWords {
    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println(new T151_ReverseWords().reverseWords(str));
    }

    public String reverseWords(String s, int a) {
        s = s.trim();
        StringBuilder strBuilder = new StringBuilder(); // 移除末尾空格
        int i, j;
        i = j = s.length() - 1;
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 追加单词
            strBuilder.append(s, i + 1, j + 1).append(" ");
            // 跳过单词间连续的空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;  // j指向下一个单词的末尾字符
        }
        return String.valueOf(strBuilder).trim();
    }

    // 内置函数
    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isEmpty())
                stringBuffer.append(split[i]).append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return String.valueOf(stringBuffer);
    }
}
