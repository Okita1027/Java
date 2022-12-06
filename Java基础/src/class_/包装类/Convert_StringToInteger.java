package class_.包装类;

/**
 * @author 秦智耘
 * @Date 2021/8/8 - 2021年8月8日15:13:47
 */
@SuppressWarnings({"all"})
public class Convert_StringToInteger
{
    public static void main(String[] args)
    {
        //包装类——>String类
        Integer i = 10;
        //方法1:
        String s1 = i.toString();
        //方法2：
        String s2 = String.valueOf(i);
        //方法3：
        String s3 = i + "";

        //String——>包装类
        //方法1：
        Integer j = new Integer(s1);
        //方法2：
        Integer j2 = Integer.valueOf(s2);

    }
}
