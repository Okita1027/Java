package algorithm.easy;

/**
 * @Author qzy
 * @ClassName BeforeAfterSubString
 * @Description 输出子串前后字符
 * @Date 2023/1/28 20:55 星期六
 */
public class BeforeAfterSubString {
    public static void main(String[] args) {
        isSub("HelloWorldQinZhiyun", "World");
    }

    //str2是否是str1的子串
    public static void isSub(String str1, String str2) {
        int index;
        if ((index = str1.indexOf(str2)) == -1) {
            return ;
        }
        for (int i = 0; i < index; i++) {
            System.out.print(str1.charAt(i));
        }
        for (int i = index + str2.length(); i < str1.length(); i++) {
            System.out.print(str1.charAt(i));
        }
    }
}
