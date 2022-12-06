package collection.List;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Title 遍历集合的三种方式
 * @author 秦智耘
 * @Date 2021年8月12日17:21:58
 */

public class ListFor_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        person p1 = new person("qzy", 18, 175);
        person p2 = new person("hlf", 17, 173);
        person p3 = new person("zk", 18, 172);
        ArrayList arrayList = new ArrayList();
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);

        //方法1：用迭代器Iterator
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext())
        {
            Object next =  iterator.next();
            System.out.println("next = " + next);
        }

        //方法2：用增强for循环
        for (Object obj : arrayList)
        {
            System.out.println("o = " + obj);
        }

        //方法3：用普通for循环
        for (int i = 0; i < arrayList.size(); i++)
        {
            Object obj = arrayList.get(i);
            System.out.println("obj = " + obj);
        }

    }
}
