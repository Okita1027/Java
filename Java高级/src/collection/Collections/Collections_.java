package collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 秦智耘
 * @Title Collections工具类
 * @Date 2021年8月18日09:04:51
 */
@SuppressWarnings({"all"})
public class Collections_
{
    public static void main(String[] args)
    {
        List list = new ArrayList();
        list.add("qwer");
        list.add("asd");
        list.add("qzy");
        list.add("x");
        list.add("pq");
        list.add("qzy");
        list.add("100");
        System.out.println("list1 = " + list);
        //颠倒顺序
        Collections.reverse(list);
        System.out.println("list2 = " + list);
        //随机排序
        Collections.shuffle(list);
        System.out.println("list3 = " + list);
        //排序
        Collections.sort(list);
        System.out.println("list4 = " + list);
        //传入比较器进行排序
        Collections.sort(list, new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return ((String) o2).compareTo((String) o1);
            }
        });
        System.out.println("list5 = " + list);
        //指定位置交换
        Collections.swap(list, 0, 1);
        System.out.println("list6 = " + list);
        //使用二分查找法返回key在list中的索引，在此之前必须先对list进行排序
        Collections.sort(list);
        System.out.println("list7 = " + list);
        Object obj = Collections.binarySearch(list, "qzy");
        System.out.println("obj8 = " + obj);
        //返回最大、最小元素
        System.out.println(Collections.max(list));
        obj = Collections.min((list), new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return ((String) o2).compareTo((String) o1);
            }
        });
        System.out.println("obj9 = " + obj);
        //返回object在list中出现的次数
        System.out.println(Collections.frequency(list, "qzy"));
        //copy复制src的所有元素到dest，前提是dest的大小要>=src的大小
        ArrayList dest = new ArrayList();
        for (int i = 0; i <list.size(); i++)
        {
            dest.add(i);
        }
        System.out.println("dest10 = " + dest);
        Collections.copy(dest, list);
        System.out.println("dest11 = " + dest);
        //把list中的oldval替换成新的newval
        Collections.replaceAll(list, "qzy", "hhhhhh");
        System.out.println("list12 = " + list);
    }
}
