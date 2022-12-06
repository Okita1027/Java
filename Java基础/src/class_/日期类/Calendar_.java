package class_.日期类;

import java.util.Calendar;

/**
 * @author 秦智耘
 * @Date 2021/8/10 - 2021年8月10日16:23:28
 */
/*
//第二代日期：Calendar
* Calendar类的缺点：
* 1、可变性：日期和时间应该是不可变的。
* 2、偏移性：Date中的年份是从1900年开始的，月份是从0开始的。
* 3、格式化：格式化只对Date有用，Calendar没有专门的格式化方法，输出时需要程序员自己组合显示。
* 4、线程不安全：不能处理闰秒（每2年就会多出1秒）。
* */
public class Calendar_
{
    public static void main(String[] args)
    {
        //Calendar 类不是new而是用getInstance方法来实例化一个新的对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        //Calendar的月是从0开始的，因此要+1
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        Calendar cal = Calendar.getInstance();
        // 如果想设置为某个日期，可以一次设置年月日时分秒，由于月份下标从0开始赋值月份要-1
        // cal.set(year, month, date, hourOfDay, minute, second);
        cal.set(2021, 8, 10, 16, 25, 35);

        // 或者6个字段分别进行设置，由于月份下标从0开始赋值月份要-1
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 15);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        System.out.println(cal.getTime());

    }
}
