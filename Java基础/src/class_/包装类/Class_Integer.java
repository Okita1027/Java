package class_.包装类;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author 秦智耘
 * @Date 2021/8/8 - 2021年8月8日15:20:31
 */
@SuppressWarnings({"all"})
public class Class_Integer
{
    public static void main(String[] args)
    {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        //new出来的对象一定是不相等的！
        System.out.println(a == b); //FALSE


        Integer p = 128;
        Integer q = 128;
        //Integer p = 128 相当于把整形数据赋值给包装类，
        //其内部实现原理使用的是Integer.valueOf()方法,
        //-128~127是从一个整形数组中直接取出的，所以如果赋值的值在这个范围内，
        Integer x = 1;
        Integer y = 1;
        //1在这个范围内，所以是TRUE
        System.out.println(x == y); //TRUE
        //p == q的值就是TRUE，否则就相当于new了一个Integer对象，结果为FALSE。
        System.out.println(p == q); //FALSE

        //对于数据特别大的，使用 以下两个类来存储
        BigInteger bigInteger = new BigInteger("12312312311222222222222223123");
        System.out.println(bigInteger);
        BigDecimal bigDecimal = new BigDecimal("22222222222222222222222222222222.33333333333333333");
        System.out.println("bigDecimal = " + bigDecimal);

    }
}
