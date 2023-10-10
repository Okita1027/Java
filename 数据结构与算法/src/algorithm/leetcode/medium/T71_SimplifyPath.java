package algorithm.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qzy
 * @time 2023/10/8 8:33 星期日
 * @title 简化路径
 */
public class T71_SimplifyPath {
    /*
     给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。

     在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。

     请注意，返回的 规范路径 必须遵循下述格式：

     始终以斜杠 '/' 开头。
     两个目录名之间必须只有一个斜杠 '/' 。
     最后一个目录名（如果存在）不能 以 '/' 结尾。
     此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     返回简化后得到的 规范路径 。
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        // '/'是每个目录的间隔符，不需要处理
        for (String item : path.split("/")) {
            // ..代表上级目录->弹出栈顶元素
            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            // .代表当前目录->不需要处理
            } else if (!item.isEmpty() && !item.equals(".")) {
                //栈中只存储目录名
                stack.push(item);
            }
        }

        /*
            在每个目录名之前加上分隔符 '/'
         */
        StringBuilder result = new StringBuilder();
        for (String d : stack) {
            result.insert(0, "/" + d);
        }
        //结果为空说明是根目录
        return (result.isEmpty()) ? "/" : result.toString();
    }

    public static void main(String[] args) {
        String str = "/home//foo/";
        String result = new T71_SimplifyPath().simplifyPath(str);
        System.out.println("result = " + result);

        str = "/../";
        result = new T71_SimplifyPath().simplifyPath(str);
        System.out.println("result = " + result);

        str = "/home/";
        result = new T71_SimplifyPath().simplifyPath(str);
        System.out.println("result = " + result);
    }
}
