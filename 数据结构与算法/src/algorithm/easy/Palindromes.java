package algorithm.easy;

import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName Palindromes
 * @Description 回文数：12321
 * @Date 2023/2/4 20:39 星期六
 */
public class Palindromes {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        String numStr = String.valueOf(num);
        for (int i = 0, j = numStr.length() - 1; i < numStr.length() / 2; i++, j--) {
            if (numStr.charAt(i) != numStr.charAt(j)) {
                System.out.println(num + "不是回文数！");
                return;
            }
        }
        System.out.println(num + "是回文数！");
    }
}
