package class_.日期类;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author 秦智耘
 * @Date 2021/8/10 - 2021年8月10日16:40:503
 */
//第三代日期LocalDate
public class LocalDate_
{
    public static void main(String[] args)
    {
        //只获取年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //判断某个日期在另一个日期的前面还是后面或者相等,isBefore(),isAfter(),equals();
        //equals方法比较日期是否相等：
        System.out.println("今天是2021-8-10吗？" + localDate.equals(LocalDate.now()));
        //获取自己想要的日期：
        localDate = LocalDate.of(2020, 1, 1);
        System.out.println(localDate);
        //日期的加减操作：获取明年的今天：
        localDate.plus(1, ChronoUnit.YEARS);
        System.out.println(localDate);
        //检查闰年现在只需要一个isLeapYear()方法就行了：
        System.out.println(localDate.isLeapYear());
        //日期格式化：
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy - MM - dd - HH:mm:ss a");
        String str = ldt.format(dateTimeFormatter);
        System.out.println(ldt);
        System.out.println(str);

        //只获取时分秒
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //年月日时分秒都要：
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //带时区的完整时间，它根据UTC/格林威治时间来进行时区调整
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
