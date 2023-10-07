package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @Date 2022/6/12 15:08 星期日
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 */
public class T20_ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(char c: s.toCharArray()){
            //如果是左括号，就直接压栈
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            //如果遇到右括号的时候，栈是空的就代表这个这个右括号是单独出现的，返回false
            //如果出栈的括号与当前括号不是一种，则表明括号不匹配，返回false
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        //最后栈是空的，表明括号匹配没有问题
        return stack.isEmpty();
    }

    //二：
//    public boolean isValid(String s) {
//        int length = s.length() / 2;
//        for (int i = 0; i < length; i++) {
//            s = s.replace("()", "").replace("{}", "").replace("[]", "");
//        }
//
//        return s.length() == 0;
//    }
}
