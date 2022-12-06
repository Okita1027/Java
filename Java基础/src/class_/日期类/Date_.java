package class_.日期类;

import java.util.Date;

/**
 * @author 秦智耘
 * @date 2021/8/6 - 2021年8月6日08:55:01
 */
//第一代日期Date
public class Date_
{
    public static void main(String[] args)
    {
        Date date = new Date();
        System.out.println(date);   //Fri Aug 06 09:00:05 CST 2021; CST表示China Standard Time

        date = new Date(1000L);     //默认的毫秒时间是从1970开始的，中国为“东八区”，时间推迟8小时
        System.out.println(date);

        long time = date.getTime(); //把当前的时间转换成毫秒
        System.out.println(time);   //Thu Jan 01 08:00:01 CST 1970

    }
}
