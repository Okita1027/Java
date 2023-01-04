package test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @Author qzy
 * @ClassName Test10
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/2 21:29 星期一
 */
public class Test10 {
    @Test
    public void test() {
        Integer i1 = Integer.valueOf("123");
        int i2 = Integer.parseInt("321");
        //代表23是八进制的
        int i = Integer.parseInt("23", 8);
        System.out.println("i = " + i); //19
//        Double d = new Double();//没有无参构造
        StringBuilder stringBuilder = new StringBuilder("123456");
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(stringBuilder == reverse);//true

        char[] chars = {'a', 'b', 'c', 'd'};
        stringBuilder.insert(1, chars, 2, 2);
        System.out.println("stringBuilder = " + stringBuilder);

        StringBuilder s = new StringBuilder("java");
        System.out.println("s.substring(1,2) = " + s.substring(1, 2));
        s.delete(1, 2);
        System.out.println("s = " + s);
        StringBuilder s2 = new StringBuilder("qwert");
        s2.delete(1, 6);
        System.out.println("s2 = " + s2);
    }
}
