package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author qzy
 * @time 2023/10/27 9:10 星期五
 * @title 541-反转字符串II
 */
public class T541_ReverseStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        T541_ReverseStringII fun = new T541_ReverseStringII();
        String result = fun.reverseStr(s, k);
        System.out.println("result = " + result);

        s = "abcd";
        result = fun.reverseStr(s, k);
        System.out.println("result = " + result);
    }
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int left = i;
            int right = Math.min(left + k - 1, s.length() - 1);
            while (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return Arrays.toString(charArray);
    }


}
