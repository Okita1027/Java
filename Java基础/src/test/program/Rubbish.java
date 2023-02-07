package test.program;

import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName Rubbish
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/2/7 23:04 星期二
 */
public class Rubbish {
    public static void main(String[] args) {
        String[] str = {"size", "abs", "length", "class"};
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++)
            System.out.print(str[i] + "    ");
        System.out.println(str[0].length());
    }
}
