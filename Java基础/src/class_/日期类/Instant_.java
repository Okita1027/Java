package class_.日期类;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author 秦智耘
 * @Date 2021/8/11 - 2021年8月11日15:04:05
 */
//时间线上的某一点：Instant
public class Instant_
{
    public static void main(String[] args)
    {
        //now:本初子午线时间
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        //添加时间的偏移量：CN为东八区，调整8小时的时差
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);

        //获取UTC开始至今的毫秒数
        long milli = Instant.now().toEpochMilli();
        System.out.println("milli = " + milli);

        //通过给定的毫秒数，来获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(10000000000L);
        System.out.println("instant1 = " + instant1);
    }
}
