package algorithm.leetcode.other;

/**
 * @author qzy
 * @time 2023/11/23 10:14 星期四
 * @title 卡码网KamaCoder-54.替换数字
 */
public class ReplaceNumber {
    public static void main(String[] args) {
        String source = "a1b2c3";
        ReplaceNumber fun = new ReplaceNumber();
        System.out.println(fun.replaceNumber(source));
    }
    public String replaceNumber(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (isNumber(current)) {
                res.append("number");
            } else {
                res.append(current);
            }
        }
        return res.toString();
    }

    private boolean isNumber(Character ch) {
        return ch >= 'A' && ch <= 'z';
    }
}
