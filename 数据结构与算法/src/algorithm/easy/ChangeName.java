package algorithm.easy;

import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName ChangeName
 * @Description 把两个词的人名改写为第一个字母大写，其余字母小写。例如，输入：noRtH CARolIna，将生成输出：North Carolina。
 * @Date 2023/2/5 21:05 星期日
 */
public class ChangeName {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String name = scanner.nextLine();
        /*final String[] split = name.split(" ");
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            final String lowerCase = split[i].toLowerCase();
            strBuilder.append((char) (lowerCase.charAt(0) - 32));
            strBuilder.append(lowerCase.substring(1));
            strBuilder.append(" ");
        }
        System.out.println("strBuilder = " + strBuilder);*/
        StringBuilder nameBuilder = new StringBuilder();
        if (name.charAt(0) >= 97) {
            nameBuilder.append((char)(name.charAt(0) - 32));
        }
        for (int i = 1; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (charAt == ' ') {
                nameBuilder.append(' ');
                char next = name.charAt(++i);
                if (next >= 97) {
                    next -= 32;
                }
                nameBuilder.append(next);
            } else {
                if (charAt < 97) {
                    charAt += 32;
                }
                nameBuilder.append(charAt);
            }
        }
        System.out.println("name = " + nameBuilder);
    }
}
