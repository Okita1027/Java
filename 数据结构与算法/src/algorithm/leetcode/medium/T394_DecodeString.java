package algorithm.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/8 16:39 星期日
 * @title 394-字符串解码
 */
public class T394_DecodeString {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        T394_DecodeString fun = new T394_DecodeString();
        String result = fun.decodeString(str);
        System.out.println("result = " + result);

        str = "2[a]2[bc3[d]]e1[f]";
        result = fun.decodeString(str);
        System.out.println("result = " + result);
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();    // 临时结果
        int multi = 0;  // 倍数
        Deque<Integer> multiStack = new LinkedList<>();    // 倍数栈
        Deque<String> resultStack = new LinkedList<>();    // 倍数 * 字母的临时结果栈
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                // '['时，入栈当前倍数，用于后续重复字符串
                multiStack.addLast(multi);
                // 记录这个'['前的结果，便于后续的拼接
                resultStack.addLast(res.toString());
                // 进入了新的[]，要重置倍数和字母串
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // ']'时，取出之前的字母串乘、倍数
                StringBuilder tmp = new StringBuilder();
                int cur_multi = multiStack.removeLast();
                // 重复字符串
                for (int i = 0; i < cur_multi; i++)
                    tmp.append(res);
                // 记录为临时结果以便下次遇到’[‘时压栈
                res = new StringBuilder(resultStack.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                // 多位倍数要先自己*10再加上新倍数
                multi = multi * 10 + c - '0';
            } else {
                // 累计括号中的普通字母
                res.append(c);
            }
        }
        return res.toString();
    }

}