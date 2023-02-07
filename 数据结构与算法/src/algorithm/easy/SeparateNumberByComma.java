package algorithm.easy;

/**
 * @Author qzy
 * @ClassName SeparateNumberByComma
 * @Description 用，分隔数字
 * @Date 2023/2/2 22:00 星期四
 */
public class SeparateNumberByComma {
    public static void main(String[] args) {
        System.out.println("1234567890.123456");
        System.out.println(toSeparateNumber("1234567890.12345"));
        System.out.println("1234567890");
        System.out.println(toSeparateNumber("1234567890"));
    }
    //以 , 分隔大数字
    public static String toSeparateNumber(String str) {
        final StringBuilder stringBuilder = new StringBuilder(str);
        final int point = stringBuilder.lastIndexOf(".");
        int last;
        //lastIndexOf没找到的时候返回值是-1
        if (point != -1) {
            //找到小数点，则下标定位到小数点
            last = point;
        } else {
            //没找到小数点，则下标定位到末位的后一位
            last = stringBuilder.length();
        }
        //当前位置往左挪三位插入 ,
        for (int i = last - 3; i > 0; i -= 3) {
            stringBuilder.insert(i, ',');
        }
        return String.valueOf(stringBuilder);
    }
}
