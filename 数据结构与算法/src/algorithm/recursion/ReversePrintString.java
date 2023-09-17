package algorithm.recursion;

/**
 * @author qzy
 * @time 2023/9/14 8:44 星期四
 * 逆序打印字符串
 */
public class ReversePrintString {

    static void fun(String str, int index) {
        if (index == str.length())
            return;
        fun(str, index + 1);
        System.out.print(str.charAt(index));
    }

    public static void main(String[] args) {
        fun("HelloWorld!", 0);
    }
}
