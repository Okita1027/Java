package class_.包装类;

import java.util.Scanner;

/**
 * @time 2022/4/27 21:31 星期三
 * StringBuffer练习
 * StringBuffer与String：
 * String 是 final 类型，每次更改它的值实际上是创建了一个新String并把地址指向他
 * 而StringBuffer不是final类型，所以它每次更改值就是单纯改变值而已，效率高
 * StringBuffer在无参构造函数中，默认分配16个字节空间。后续不够用时会自动追加到当前的两倍
 */
public class StringBuffer_
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer(scanner.next());
        int i = stringBuffer.lastIndexOf(".");
        while ((i = i - 3)  > 0)
        {
            stringBuffer.insert(i, ',');
        }

        System.out.println(stringBuffer);
    }
}
