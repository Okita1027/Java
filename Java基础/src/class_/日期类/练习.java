package class_.日期类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 秦智耘
 * @date 2021/8/6 - 2021年8月6日10:01:39
 */
public class 练习
{
    //计算一个人出生到现在活了多少天
    public static void main(String[] args) throws ParseException
    {
        System.out.print("输入你的出生日期(yyyy-MM-dd)：");
        String text = new Scanner(System.in).next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(text);
        Date datenow = new Date();
        long time1 = date.getTime();
        long time2 = datenow.getTime();
        long day = (time2 - time1) / 1000 / 60 / 60 / 24;
        System.out.println("已经活了" + day + "天");

    }
}
