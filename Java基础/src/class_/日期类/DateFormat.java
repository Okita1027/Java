package class_.日期类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 秦智耘
 * @date 2021/8/6 - 2021年8月6日09:30:20
 */
public class DateFormat
{
    public static void main(String[] args) throws ParseException
    {
        //创建一个SimpleDateFormat, ""内写的是你想要输出的日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date date = new Date();
        String text = sdf.format(date);
        System.out.println(date);   //Fri Aug 06 09:53:23 CST 2021
        System.out.println(text);   //2021-08-06 09-53-23

        //把符合sdf构造方法中格式的日期转换成Date原本的Date形式
        date = sdf.parse("2021-08-06 09-56-35");    //这里调用parse方法会抛出异常，目前就把它抛给虚拟机去处理
        System.out.println(date);

    }
}
