package algorithm.easy;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName LetterStatistics
 * @Description 统计字符数目
 * @Date 2023/1/8 17:32 星期日
 */
public class LetterStatistics {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine().toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i), 0);
            map.put(str.charAt(i), ++count);
        }
        for (Character character : map.keySet()) {
            System.out.println(character + "的出现次数：" + map.get(character));
        }

        /*Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int num = 0, letter = 0, space = 0, other = 0;
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                num++;
            } else if (c >= 'A' && c <= 'z') {
                letter++;
            } else if (c == ' ') {
                space++;
            } else {
                other++;
            }
        }
        System.out.println("数字" + num);
        System.out.println("字母" + letter);
        System.out.println("空格" + space);
        System.out.println("其它" + other);*/
    }

}
