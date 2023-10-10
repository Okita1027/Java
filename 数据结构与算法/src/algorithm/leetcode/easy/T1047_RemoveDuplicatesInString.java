package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * @author qzy
 * @time 2023/9/23 12:28 星期六
 * T1047—— 删除字符串中相邻的重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class T1047_RemoveDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //若栈为空或当前元素与栈顶元素不相等，则压栈当前元素
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                //若相等，则移除栈顶元素
                stack.pop();
            }
        }
        /*
            将栈中的元素逆序输出
         */
        StringBuffer str = new StringBuffer();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
