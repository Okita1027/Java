package algorithm.leetcode.easy;

/**
 * @author qzy
 * @time 2023/10/28 13:57 星期六
 * @title 459-重复的字符串
 */
public class T459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        /*
         如果您的字符串 S 包含一个重复的子字符串，那么这意味着您可以多次 “移位和换行”`您的字符串，并使其与原始字符串匹配。

         例如：abcabc

         移位一次：cabcab 移位两次：bcabca 移位三次：abcabc

         现在字符串和原字符串匹配了，所以可以得出结论存在重复的子串。

         基于这个思想，可以每次移动k个字符，直到匹配移动 length - 1 次。但是这样对于重复字符串很长的字符串，效率会非常低。在 LeetCode 中执行 时间超时了。

         为了避免这种无用的环绕，可以创建一个新的字符串 str，它等于原来的字符串 S 再加上 S 自身，这样其实就包含了所有移动的字符串。

         比如字符串：S = acd，那么 str = S + S = acdacd

         acd 移动的可能：dac、cda。其实都包含在了 str 中了。就像一个滑动窗口

         一开始 acd (acd) ，移动一次 ac(dac)d，移动两次 a(cda)cd。循环结束

         所以可以直接判断 str 中去除首尾元素之后，是否包含自身元素。如果包含。则表明存在重复子串。
         */
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
