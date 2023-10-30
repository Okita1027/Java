package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/27 16:18 星期五
 * @title 28-找出字符串中第一个匹配项的下标
 */
public class T28_KMP {
    public static void main(String[] args) {
        String text = "ABABABA";
        String pattern = "ABA";
        int[] next = new int[pattern.length()];
        T28_KMP kmp = new T28_KMP();
        kmp.getNext(next, pattern);

        int index = kmp.strStr(text, pattern);
        System.out.println("index = " + index);
    }
    public int strStr(String haystack, String needle) {
        // 创建 next 数组，用于存储模式串的最长公共前后缀长度
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                // 如果当前字符匹配成功，则同时向前移动文本串和模式串的指针
                i++;
                j++;
            } else {
                // 如果当前字符匹配失败，则根据 next 数组移动模式串的指针
                j = next[j];
            }
        }

        // 返回匹配结果
        return j == needle.length() ? i - j : -1;
    }

    private void getNext(int[] next, String str) {
        int i = 0, j = -1;
        next[0] = -1;

        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                // 如果当前字符匹配成功，则同时向前移动 i 和 j，并将 next[i+1] 设置为 j+1
                next[++i] = ++j;
            } else {
                // 如果当前字符匹配失败，则根据 next 数组回溯 j 的位置
                j = next[j];
            }
        }
    }

}
