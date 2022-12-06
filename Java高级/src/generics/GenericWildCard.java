package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 秦智耘
 * @Title 泛型通配符
 * @Date 2021年8月19日22:06:00
 */
public class GenericWildCard
{
    public static void main(String[] args)
    {

        //泛型没有继承性，这样写是错误的
        //List<Object> lst = new ArrayList<String>();
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("231");
        objects.add("232");
        objects.add("234");
        method3(objects);

    }
    // ? 表示任意泛型类型都可以接受
    public static void method1(List<?> c)
    {
        for (Object o : c)
            System.out.println("o = " + o);
    }
    //? extends A 表示上限，可以接受A或是A的子类
    public static void method2(List<? extends A> c)
    {
        for (Object o : c)
            System.out.println("o = " + o);
    }
    // ? supper 子类类名A：支持A类及A类的父类，不限于直接父类
    //规定了泛型的下限
    public static void method3(List<? super A> c)
    {
        for (Object o : c)
            System.out.println("o = " + o);
    }
}

class A
{}