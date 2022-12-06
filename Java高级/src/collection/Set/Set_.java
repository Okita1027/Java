package collection.Set;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 秦智耘
 * @Title Set简介
 * @Date 2021年8月13日19:31:19
 */
public class Set_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        /*
        * Set不能储存相同的数据且是无序的，所以不能通过索引来获得对应的值
        * 遍历Set的方法也只能用迭代器Iterator和增强for循环
        * 取出数据的顺序和存放的顺序是不同的，但不会每次取出数据都不相同
        * */
        Set set = new HashSet();
        set.add("C");
        set.add("Java");
        set.add("Python");
        set.add("null");
        set.add(null);
        System.out.println("set = " + set);

        //遍历方法1、迭代器Iterator
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Object next =  iterator.next();
            System.out.print("next = " + next + "\t");
        }

        System.out.println();

        //遍历方法2、增强for循环（也可以叫foreach）
        for (Object obj : set)
        {
            System.out.print("obj = " + obj + "\t");
        }

    }
}
