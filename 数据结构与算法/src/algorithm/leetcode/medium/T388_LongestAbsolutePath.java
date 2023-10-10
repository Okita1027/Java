package algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author qzy
 * @time 2023/10/8 10:16 星期日
 * @title 388——文件的最长绝对路径
 */
public class T388_LongestAbsolutePath {
    /*
    假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例：



这里将 dir 作为根目录中的唯一目录。dir 包含两个子目录 subdir1 和 subdir2 。subdir1 包含文件 file1.ext 和子目录 subsubdir1；subdir2 包含子目录 subsubdir2，该子目录下包含文件 file2.ext 。

在文本格式中，如下所示(⟶表示制表符)：

dir
⟶ subdir1
⟶ ⟶ file1.ext
⟶ ⟶ subsubdir1
⟶ subdir2
⟶ ⟶ subsubdir2
⟶ ⟶ ⟶ file2.ext
如果是代码表示，上面的文件系统可以写为 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 。'\n' 和 '\t' 分别是换行符和制表符。

文件系统中的每个文件和文件夹都有一个唯一的 绝对路径 ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 '/' 连接。上面例子中，指向 file2.ext 的 绝对路径 是 "dir/subdir2/subsubdir2/file2.ext" 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 name.extension 的格式，其中 name 和 extension由字母、数字和/或空格组成。

给定一个以上述格式表示文件系统的字符串 input ，返回文件系统中 指向 文件 的 最长绝对路径 的长度 。 如果系统中没有文件，返回 0。



示例 1：


输入：input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
输出：20
解释：只有一个文件，绝对路径为 "dir/subdir2/file.ext" ，路径长度 20
示例 2：


输入：input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
输出：32
解释：存在两个文件：
"dir/subdir1/file1.ext" ，路径长度 21
"dir/subdir2/subsubdir2/file2.ext" ，路径长度 32
返回 32 ，因为这是最长的路径
示例 3：

输入：input = "a"
输出：0
解释：不存在任何文件
示例 4：

输入：input = "file1.txt\nfile2.txt\nlongfile.txt"
输出：12
解释：根目录下有 3 个文件。
因为根目录中任何东西的绝对路径只是名称本身，所以答案是 "longfile.txt" ，路径长度为 12


提示：

1 <= input.length <= 104
input 可能包含小写或大写的英文字母，一个换行符 '\n'，一个制表符 '\t'，一个点 '.'，一个空格 ' '，和数字。
     */
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String[] split = input.split("\n");
        System.out.println(split.length + "split = " + Arrays.toString(split));
        split = input.split("\t");
        System.out.println(split.length + "split = " + Arrays.toString(split));
    }

    /**
     * 计算给定字符串中最长路径的长度
     * @param input 给定的字符串
     * @return 最长路径的长度
     */
    public int lengthLongestPath(String input) {
        // 将输入字符串按照换行符进行分割，得到一个字符串数组
        String[] split = input.split("\n");
        // 创建一个栈，并压入初始值0(根目录的长度)
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        // 用于记录最长路径的长度
        int result = 0;

        // 遍历输入的字符串数组
        for (int i = 0; i < split.length; i++) {
            // 根据当前行的水平层级获取层级数level
            int level = level(split[i]);
            // 如果栈中元素的层级数小于当前层级数，弹出栈顶元素，直到栈中元素的层级数大于当前层级数
            while (stack.size() > level + 1) {
                stack.pop();
            }
            // 获取当前行的水平位置减去当前层级数，再加上栈顶元素的水平位置，得到当前路径的长度l
            int l = split[i].length() - level + stack.peek();
            // 如果当前行包含"."，说明当前路径需要跨越多个层级，更新最长路径的长度为l加上当前层级数
            if (split[i].contains(".")) {
                result = Math.max(result, l + level);
            } else {
                // 否则，将当前路径长度l压入栈中，以便后续处理
                stack.push(l);
            }
        }
        // 返回最长路径的长度
        return result;
    }

    /**
     * 根据给定的字符串获取其水平层级数
     * @param path 给定的字符串
     * @return 字符串的水平层级数，如果字符串中没有换行符则返回-1
     */
    public int level(String path) {
        // 遍历字符串中的每个字符，直到遇到换行符或者字符串结束符'\0'
        for (int i = 0; i < path.length(); i++) {
            // 如果当前字符不是换行符，则返回当前字符的位置作为当前路径的水平层级数，否则返回-1表示路径仅由一行组成
            if (path.charAt(i) != '\t') {
                return i;
            }
        }
        // 如果遍历结束仍未找到换行符或结束符，则返回-1表示路径仅由一行组成
        return -1;
    }

}
