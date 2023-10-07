package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @author qzy
 * @time 2023/9/23 12:28 星期六
 */
public class T1047_RemoveDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuffer str = new StringBuffer();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
